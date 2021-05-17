package java8语法.Lambda表达式.流处理.隐藏文件;

import java.io.File;
import java.io.FileFilter;

/**
 * @author zhaokai108
 * @version 0.1.0
 * @description:
 * @create 2021-02-24 18:30
 * @since 0.1.0
 **/
public class Case {

    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        File[] hiddenFilesP = new File(".").listFiles(File::isHidden);
    }
}
