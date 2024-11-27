package org.example.lox;

public class AstPrinter implements Expr.Visitor<String> {

    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        return paranthesize(expr.operator.lexeme, expr.right, expr.left);
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return paranthesize("group", expr.expression);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        return paranthesize(expr.operator.lexeme, expr.right);
    }

    @Override
    public String visitVariableExpr(Expr.Variable expr) {
        return "";
    }

    private String paranthesize(String name, Expr... exprs) {
        StringBuilder sb = new StringBuilder();

        sb.append("(").append(name);
        for (Expr expr : exprs) {
            sb.append(" ").append(expr.accept(this));
        }
        sb.append(")");

        return sb.toString();
    }
}
