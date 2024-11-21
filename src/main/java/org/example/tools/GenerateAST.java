package org.example.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class GenerateAST {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: generate_ast <output_directory>");
            System.exit(64);
        }
        String outputDir = args[0];
        defineAst(outputDir, "Expr", Arrays.asList(
                "Binary : Expr left, Token operator, Expr right",
                "Grouping : Expr expression",
                "Literal : Object value",
                "Unary : Token operator, Expr right"
        ));
    }

    public static void defineAst(String outputDir, String basename, List<String> types) throws IOException {
        String path = outputDir + "/" + basename + ".java";
        PrintWriter writer = new PrintWriter(path, StandardCharsets.UTF_8);

        writer.println("package org.package.lox");
        writer.println();
        writer.println("import java.util.List");
        writer.println();
        writer.println("abstract class " + basename + " {");

        for (String type : types) {
            String className = type.split(":")[0].trim();
            String fields = type.split(":")[1].trim();
            defineType(writer, basename, className, fields);
        }

        writer.println("}");
        writer.close();
    }

    public static void defineType(PrintWriter writer, String baseName, String className, String fieldList) {
        writer.println(" static class " + className + " extends " + baseName + " {");

        writer.println("    " + className + "(" + fieldList + ") {");

        String[] fields = fieldList.split(",");
        for (String field : fields) {
            String name = field.split(" ")[1];
            writer.println("    this." + name + " = " + name + ";");
        }

        writer.println("    }");

        writer.println();
        for (String field : fields) {
            writer.println("    final " + field + ";");
        }

        writer.println("  }");
    }

}
