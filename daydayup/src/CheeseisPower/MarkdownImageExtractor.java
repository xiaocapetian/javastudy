package CheeseisPower;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MarkdownImageExtractor {

    public static void main(String[] args) {
        String filePath = "E:\\flanlin\\study\\Java\\[08]javaRedis"+"\\";
        Path baseDir = Paths.get(filePath);
        Path assetsDir = baseDir.resolve("assets");
        Path backupDir = baseDir.resolve("backups");

        try {
            if (!Files.exists(assetsDir)) {
                Files.createDirectories(assetsDir);
            }
            if (!Files.exists(backupDir)) {
                Files.createDirectories(backupDir);
            }

            try (Stream<Path> paths = Files.walk(baseDir)) {
                paths.filter(Files::isRegularFile)
                        .filter(path -> path.toString().endsWith(".md"))
                        .forEach(markdownFile -> {
                            System.out.println("Processing file: " + markdownFile.toString());
                            backupFile(markdownFile, backupDir);
                            processFile(markdownFile, baseDir, assetsDir);
                        });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void backupFile(Path markdownFile, Path backupDir) {
        Path relativePath = markdownFile.getParent().relativize(markdownFile);
        Path backupFile = backupDir.resolve(relativePath).normalize();
        try {
            Files.createDirectories(backupFile.getParent()); // 创建备份文件的父目录
            Files.copy(markdownFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup created: " + backupFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(Path markdownFile, Path baseDir, Path assetsDir) {
        try {
            String content = new String(Files.readAllBytes(markdownFile));
            String updatedContent = processMarkdown(content, baseDir, assetsDir);
            Files.write(markdownFile, updatedContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processMarkdown(String content, Path baseDir, Path assetsDir) throws IOException {
        Pattern imgPattern = Pattern.compile("!\\[.*?\\]\\((.*?)\\)|<img\\s+([^>]*?)src=\"(.*?)\"([^>]*?)>");
        Matcher matcher = imgPattern.matcher(content);

        StringBuffer updatedContent = new StringBuffer();

        while (matcher.find()) {
            String imgPath = matcher.group(1) != null ? matcher.group(1) : matcher.group(3);

            if (imgPath.startsWith("http://") || imgPath.startsWith("https://")) {
                matcher.appendReplacement(updatedContent, Matcher.quoteReplacement(matcher.group(0)));
            } else {
                Path imgFile = baseDir.resolve(imgPath).normalize();

                if (Files.exists(imgFile)) {
                    Path newImgPath = assetsDir.resolve(imgFile.getFileName());
                    Files.copy(imgFile, newImgPath, StandardCopyOption.REPLACE_EXISTING);
                    String relativePath = "assets/" + imgFile.getFileName().toString();

                    if (matcher.group(1) != null) {
                        matcher.appendReplacement(updatedContent, Matcher.quoteReplacement("![](" + relativePath + ")"));
                    } else {
                        matcher.appendReplacement(updatedContent, Matcher.quoteReplacement("<img " + matcher.group(2) + "src=\"" + relativePath + "\"" + matcher.group(4) + ">"));
                    }
                } else {
                    matcher.appendReplacement(updatedContent, Matcher.quoteReplacement(matcher.group(0)));
                }
            }
        }

        matcher.appendTail(updatedContent);

        return updatedContent.toString();
    }
}