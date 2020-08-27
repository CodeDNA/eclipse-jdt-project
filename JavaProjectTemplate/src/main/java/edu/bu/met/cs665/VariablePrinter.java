package edu.bu.met.cs665;


import org.eclipse.jdt.core.dom.*;



public class VariablePrinter {
    // ! ERROR IN THIS METHOD || Import error **********************************
    public static ASTNode getASTNode(String codeFragment) {
        ASTParser parser = ASTParser.newParser(AST.JLS8);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setSource(codeFragment.toCharArray());
        parser.setResolveBindings(false);

        ASTNode node = null;
        try {
            node = (CompilationUnit) parser.createAST(null);
        } catch (Exception e) {
            return null;
        }
        return node;

    }

    public static void printVariables(String codeFragment) {
        ASTNode node = getASTNode(codeFragment);
        node.accept(new ASTVisitor() {

            int varCount = 0;

            @Override
            public boolean visit(VariableDeclarationFragment node) {
                System.out.println(node.getName().toString());
                return super.visit(node);
            }

            ;
        });
    }
}
