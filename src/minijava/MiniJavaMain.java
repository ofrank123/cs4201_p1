package minijava;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class MiniJavaMain {

    public static void main(String[] args) throws Exception {

        String inputFile = null;

        if (args.length > 0 )
            inputFile = args[0];

        CharStream charStream = null;

        if (inputFile != null ) charStream = CharStreams.fromFileName(inputFile);

        MiniJavaGrammarLexer lexer = new MiniJavaGrammarLexer(charStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MiniJavaGrammarParser parser = new MiniJavaGrammarParser(tokens);

        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();

        ScopeChecker symbolTableBuilder = new ScopeChecker(parser);

        walker.walk(symbolTableBuilder, tree);
    }


}
