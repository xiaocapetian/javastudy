package CheeseisPower;

import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class MarkdownImageExtractor {

    public static void main(String[] args) {
        String FilePath = "E:\\flanlin\\study\\守护我\\操作系统\\";
        String markdownFilePath = FilePath + "【008】操作系统.md"; // 修改为你的Markdown文件路径
        Path markdownFile = Paths.get(markdownFilePath);
        Path assetsDir = Paths.get(FilePath+"assets");

        try {
            if (!Files.exists(assetsDir)) {
                Files.createDirectories(assetsDir);
            }

            // 打印文件路径以调试
            System.out.println("Markdown file path: " + markdownFile.toString());

            String content = new String(Files.readAllBytes(markdownFile));
            String updatedContent = processMarkdown(content, markdownFile.getParent(), assetsDir);
            Files.write(markdownFile, updatedContent.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processMarkdown(String content, Path baseDir, Path assetsDir) throws IOException {
        // Pattern to match both ![]() and <img src="">
        Pattern imgPattern = Pattern.compile("!\\[.*?\\]\\((.*?)\\)|<img\\s+([^>]*?)src=\"(.*?)\"([^>]*?)>");
        Matcher matcher = imgPattern.matcher(content);

        StringBuffer updatedContent = new StringBuffer();

        while (matcher.find()) {
            String imgPath = matcher.group(1) != null ? matcher.group(1) : matcher.group(3);

            // Check if the path is a URL
            if (imgPath.startsWith("http://") || imgPath.startsWith("https://")) {
                // Do not change URLs
                matcher.appendReplacement(updatedContent, matcher.group(0));
            } else {
                Path imgFile = Paths.get(imgPath);

                if (imgFile.isAbsolute() && Files.exists(imgFile)) {
                    Path newImgPath = assetsDir.resolve(imgFile.getFileName());
                    Files.copy(imgFile, newImgPath, StandardCopyOption.REPLACE_EXISTING);
                    String relativePath = "assets/" + imgFile.getFileName().toString();

                    if (matcher.group(1) != null) {
                        matcher.appendReplacement(updatedContent, "![](" + relativePath + ")");
                    } else {
                        matcher.appendReplacement(updatedContent, "<img " + matcher.group(2) + "src=\"" + relativePath + "\"" + matcher.group(4) + ">");
                    }
                } else {
                    matcher.appendReplacement(updatedContent, matcher.group(0));
                }
            }
        }

        matcher.appendTail(updatedContent);

        return updatedContent.toString();
    }
}
