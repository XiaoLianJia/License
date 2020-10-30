package com.license.util;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * <p>
 *     命令行工具
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
public class CommandLineUtil {

    @NotNull
    public static StringBuilder execute(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("GB2312")));
        StringBuilder builder = new StringBuilder();
        String line;
        while (null != (line = reader.readLine())) {
            builder.append(line);
        }

        process.destroy();
        return builder;
    }

    @NotNull
    public static StringBuilder execute(String command, String enter) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        PrintWriter writer = new PrintWriter(process.getOutputStream());
        writer.println(enter);
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("GB2312")));
        StringBuilder builder = new StringBuilder();
        String line;
        while (null != (line = reader.readLine())) {
            builder.append(line);
        }

        process.destroy();
        return builder;
    }
}
