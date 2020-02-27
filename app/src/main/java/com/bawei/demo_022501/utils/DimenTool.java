package com.bawei.demo_022501.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * dimens适配：
 * 1.如果项目中 res/values 下没有 dimens.xml 文件，则自己创建 dimens.xml 名字不要错
 * 2.通过在DimenTool文件上 右键 run DimenTool.main()，运行生成基准的dimens.xml文件，生成成功后里面应该一一对应的值
 * 3.将布局文件中写死的dp（宽高，内外边距，字号等）统统使用 @dimens/XXXX 调用
 * 4.加载ScreenMatch插件
 * 5.应用上面点击右键 点击ScreenMatch
 * 6.成功过后有个重启
 */
public class DimenTool {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        //添加xml开始的标签
        String xmlStart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n <resources>\n";
        builder.append(xmlStart);
        for (int i = 0; i < 300; i++) {
            String dimenName = "    <dimen name=\"dp" + i + "\">";
            String end = "dp</dimen>";
            builder.append(dimenName).append(i).append(end).append("\n");
        }
        //添加sp
        builder.append("\n\n\n<!--sp-->\n");
        for (int i = 0; i < 50; i++) {
            String dimenName = "    <dimen name=\"sp" + i + "\">";
            String end = "sp</dimen>";
            builder.append(dimenName).append(i).append(end).append("\n");
        }
        //添加xml的尾标签
        builder.append("</resources>");
        String dimensFile = "./app/src/main/res/values/dimens.xml";
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(dimensFile)));
            out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
