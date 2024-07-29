package CheeseisPower;

import java.io.*;
import java.nio.file.*;

public class RestoreMarkdownBackup {

    public static void main(String[] args) {
        String baseDirPath = "E:\\flanlin\\study\\Java\\[10]JUC"; // 修改为你的根目录路径
        Path baseDir = Paths.get(baseDirPath);

        try {
            // 遍历指定文件夹及其所有子文件夹
            Files.walk(baseDir)
                    .filter(path -> path.toString().endsWith(".md.bak")) // 过滤出所有以 ".md.bak" 结尾的备份文件
                    .forEach(backupFile -> {
                        try {
                            // 构造原始 Markdown 文件路径
                            Path markdownFile = Paths.get(backupFile.toString().replace(".bak", ""));

                            // 恢复备份文件
                            Files.copy(backupFile, markdownFile, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Restored backup for file: " + markdownFile.toString());

                            // 删除备份文件
                            Files.deleteIfExists(backupFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

