// Generated from MiniJavaGrammar.g by ANTLR 4.7.2
package minijava;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LINE_COMMENT=3, ESC=4, AND=5, LT=6, PLUS=7, MINUS=8, 
		MUL=9, CLASS=10, PUBLIC=11, STATIC=12, VOID=13, MAIN=14, STRING=15, EXTENDS=16, 
		RETURN=17, WHILE=18, IF=19, ELSE=20, BOOLEAN=21, INT=22, SYSTEMOUT=23, 
		LENGTH=24, NEW=25, THIS=26, TRUE=27, FALSE=28, NOT=29, DOT=30, COMMA=31, 
		SEMICOLON=32, LBRACE=33, RBRACE=34, LPAREN=35, RPAREN=36, LSQUARE=37, 
		RSQUARE=38, EQUALS=39, ID=40, LETTER=41, INTEGER=42;
	public static final int
		RULE_program = 0, RULE_mainclass = 1, RULE_mainmethod = 2, RULE_classdecl = 3, 
		RULE_vardecl = 4, RULE_methoddecl = 5, RULE_methodbody = 6, RULE_formallist = 7, 
		RULE_formalrest = 8, RULE_type = 9, RULE_statement = 10, RULE_expr = 11, 
		RULE_op = 12, RULE_exprlist = 13, RULE_exprrest = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainclass", "mainmethod", "classdecl", "vardecl", "methoddecl", 
			"methodbody", "formallist", "formalrest", "type", "statement", "expr", 
			"op", "exprlist", "exprrest"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'&&'", "'<'", "'+'", "'-'", "'*'", "'class'", 
			"'public'", "'static'", "'void'", "'main'", "'String'", "'extends'", 
			"'return'", "'while'", "'if'", "'else'", "'boolean'", "'int'", "'System.out.println'", 
			"'length'", "'new'", "'this'", "'true'", "'false'", "'!'", "'.'", "','", 
			"';'", "'{'", "'}'", "'('", "')'", "'['", "']'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "LINE_COMMENT", "ESC", "AND", "LT", "PLUS", "MINUS", 
			"MUL", "CLASS", "PUBLIC", "STATIC", "VOID", "MAIN", "STRING", "EXTENDS", 
			"RETURN", "WHILE", "IF", "ELSE", "BOOLEAN", "INT", "SYSTEMOUT", "LENGTH", 
			"NEW", "THIS", "TRUE", "FALSE", "NOT", "DOT", "COMMA", "SEMICOLON", "LBRACE", 
			"RBRACE", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "EQUALS", "ID", "LETTER", 
			"INTEGER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniJavaGrammar.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainclassContext mainclass() {
			return getRuleContext(MainclassContext.class,0);
		}
		public List<ClassdeclContext> classdecl() {
			return getRuleContexts(ClassdeclContext.class);
		}
		public ClassdeclContext classdecl(int i) {
			return getRuleContext(ClassdeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			mainclass();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(31);
				classdecl();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainclassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MiniJavaGrammarParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(MiniJavaGrammarParser.LBRACE, 0); }
		public MainmethodContext mainmethod() {
			return getRuleContext(MainmethodContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MiniJavaGrammarParser.RBRACE, 0); }
		public List<MethoddeclContext> methoddecl() {
			return getRuleContexts(MethoddeclContext.class);
		}
		public MethoddeclContext methoddecl(int i) {
			return getRuleContext(MethoddeclContext.class,i);
		}
		public MainclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterMainclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitMainclass(this);
		}
	}

	public final MainclassContext mainclass() throws RecognitionException {
		MainclassContext _localctx = new MainclassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainclass);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(CLASS);
			setState(38);
			match(ID);
			setState(39);
			match(LBRACE);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					methoddecl();
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(46);
			mainmethod();
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(47);
				methoddecl();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainmethodContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(MiniJavaGrammarParser.PUBLIC, 0); }
		public TerminalNode STATIC() { return getToken(MiniJavaGrammarParser.STATIC, 0); }
		public TerminalNode VOID() { return getToken(MiniJavaGrammarParser.VOID, 0); }
		public TerminalNode MAIN() { return getToken(MiniJavaGrammarParser.MAIN, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaGrammarParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(MiniJavaGrammarParser.STRING, 0); }
		public TerminalNode LSQUARE() { return getToken(MiniJavaGrammarParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(MiniJavaGrammarParser.RSQUARE, 0); }
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(MiniJavaGrammarParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MiniJavaGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniJavaGrammarParser.RBRACE, 0); }
		public List<MethodbodyContext> methodbody() {
			return getRuleContexts(MethodbodyContext.class);
		}
		public MethodbodyContext methodbody(int i) {
			return getRuleContext(MethodbodyContext.class,i);
		}
		public MainmethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainmethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterMainmethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitMainmethod(this);
		}
	}

	public final MainmethodContext mainmethod() throws RecognitionException {
		MainmethodContext _localctx = new MainmethodContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mainmethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(PUBLIC);
			setState(56);
			match(STATIC);
			setState(57);
			match(VOID);
			setState(58);
			match(MAIN);
			setState(59);
			match(LPAREN);
			setState(60);
			match(STRING);
			setState(61);
			match(LSQUARE);
			setState(62);
			match(RSQUARE);
			setState(63);
			match(ID);
			setState(64);
			match(RPAREN);
			setState(65);
			match(LBRACE);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOLEAN) | (1L << INT) | (1L << SYSTEMOUT) | (1L << LBRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(66);
				methodbody();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassdeclContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MiniJavaGrammarParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(MiniJavaGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaGrammarParser.ID, i);
		}
		public TerminalNode LBRACE() { return getToken(MiniJavaGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniJavaGrammarParser.RBRACE, 0); }
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public List<MethoddeclContext> methoddecl() {
			return getRuleContexts(MethoddeclContext.class);
		}
		public MethoddeclContext methoddecl(int i) {
			return getRuleContext(MethoddeclContext.class,i);
		}
		public TerminalNode EXTENDS() { return getToken(MiniJavaGrammarParser.EXTENDS, 0); }
		public ClassdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterClassdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitClassdecl(this);
		}
	}

	public final ClassdeclContext classdecl() throws RecognitionException {
		ClassdeclContext _localctx = new ClassdeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classdecl);
		int _la;
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(CLASS);
				setState(75);
				match(ID);
				setState(76);
				match(LBRACE);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << ID))) != 0)) {
					{
					{
					setState(77);
					vardecl();
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PUBLIC) {
					{
					{
					setState(83);
					methoddecl();
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(89);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(CLASS);
				setState(91);
				match(ID);
				setState(92);
				match(EXTENDS);
				setState(93);
				match(ID);
				setState(94);
				match(LBRACE);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << ID))) != 0)) {
					{
					{
					setState(95);
					vardecl();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PUBLIC) {
					{
					{
					setState(101);
					methoddecl();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniJavaGrammarParser.SEMICOLON, 0); }
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitVardecl(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_vardecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			type();
			setState(111);
			match(ID);
			setState(112);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethoddeclContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(MiniJavaGrammarParser.PUBLIC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniJavaGrammarParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MiniJavaGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniJavaGrammarParser.RBRACE, 0); }
		public FormallistContext formallist() {
			return getRuleContext(FormallistContext.class,0);
		}
		public List<MethodbodyContext> methodbody() {
			return getRuleContexts(MethodbodyContext.class);
		}
		public MethodbodyContext methodbody(int i) {
			return getRuleContext(MethodbodyContext.class,i);
		}
		public MethoddeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methoddecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterMethoddecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitMethoddecl(this);
		}
	}

	public final MethoddeclContext methoddecl() throws RecognitionException {
		MethoddeclContext _localctx = new MethoddeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methoddecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(PUBLIC);
			setState(115);
			type();
			setState(116);
			match(ID);
			setState(117);
			match(LPAREN);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INT) | (1L << ID))) != 0)) {
				{
				setState(118);
				formallist();
				}
			}

			setState(121);
			match(RPAREN);
			setState(122);
			match(LBRACE);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOLEAN) | (1L << INT) | (1L << SYSTEMOUT) | (1L << LBRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(123);
				methodbody();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodbodyContext extends ParserRuleContext {
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MethodbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterMethodbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitMethodbody(this);
		}
	}

	public final MethodbodyContext methodbody() throws RecognitionException {
		MethodbodyContext _localctx = new MethodbodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodbody);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				vardecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormallistContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public List<FormalrestContext> formalrest() {
			return getRuleContexts(FormalrestContext.class);
		}
		public FormalrestContext formalrest(int i) {
			return getRuleContext(FormalrestContext.class,i);
		}
		public FormallistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formallist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterFormallist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitFormallist(this);
		}
	}

	public final FormallistContext formallist() throws RecognitionException {
		FormallistContext _localctx = new FormallistContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_formallist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			type();
			setState(136);
			match(ID);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(137);
				formalrest();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalrestContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(MiniJavaGrammarParser.COMMA, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public FormalrestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalrest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterFormalrest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitFormalrest(this);
		}
	}

	public final FormalrestContext formalrest() throws RecognitionException {
		FormalrestContext _localctx = new FormalrestContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_formalrest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(COMMA);
			setState(144);
			type();
			setState(145);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniJavaGrammarParser.INT, 0); }
		public TerminalNode LSQUARE() { return getToken(MiniJavaGrammarParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(MiniJavaGrammarParser.RSQUARE, 0); }
		public TerminalNode BOOLEAN() { return getToken(MiniJavaGrammarParser.BOOLEAN, 0); }
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(INT);
				setState(148);
				match(LSQUARE);
				setState(149);
				match(RSQUARE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(BOOLEAN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(INT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(152);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignmentContext extends StatementContext {
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(MiniJavaGrammarParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniJavaGrammarParser.SEMICOLON, 0); }
		public AssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitAssignment(this);
		}
	}
	public static class PrintContext extends StatementContext {
		public TerminalNode SYSTEMOUT() { return getToken(MiniJavaGrammarParser.SYSTEMOUT, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaGrammarParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaGrammarParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniJavaGrammarParser.SEMICOLON, 0); }
		public PrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitPrint(this);
		}
	}
	public static class BracesContext extends StatementContext {
		public TerminalNode LBRACE() { return getToken(MiniJavaGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniJavaGrammarParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BracesContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitBraces(this);
		}
	}
	public static class ReturnContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(MiniJavaGrammarParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniJavaGrammarParser.SEMICOLON, 0); }
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitReturn(this);
		}
	}
	public static class WhileContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(MiniJavaGrammarParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaGrammarParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaGrammarParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitWhile(this);
		}
	}
	public static class IfContext extends StatementContext {
		public TerminalNode IF() { return getToken(MiniJavaGrammarParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaGrammarParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaGrammarParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniJavaGrammarParser.ELSE, 0); }
		public IfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitIf(this);
		}
	}
	public static class ArrayAssignmentContext extends StatementContext {
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public TerminalNode LSQUARE() { return getToken(MiniJavaGrammarParser.LSQUARE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RSQUARE() { return getToken(MiniJavaGrammarParser.RSQUARE, 0); }
		public TerminalNode EQUALS() { return getToken(MiniJavaGrammarParser.EQUALS, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniJavaGrammarParser.SEMICOLON, 0); }
		public ArrayAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterArrayAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitArrayAssignment(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new BracesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(LBRACE);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << SYSTEMOUT) | (1L << LBRACE) | (1L << ID))) != 0)) {
					{
					{
					setState(156);
					statement();
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(162);
				match(RBRACE);
				}
				break;
			case 2:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(IF);
				setState(164);
				match(LPAREN);
				setState(165);
				expr(0);
				setState(166);
				match(RPAREN);
				setState(167);
				statement();
				setState(168);
				match(ELSE);
				setState(169);
				statement();
				}
				break;
			case 3:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(WHILE);
				setState(172);
				match(LPAREN);
				setState(173);
				expr(0);
				setState(174);
				match(RPAREN);
				setState(175);
				statement();
				}
				break;
			case 4:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				match(SYSTEMOUT);
				setState(178);
				match(LPAREN);
				setState(179);
				expr(0);
				setState(180);
				match(RPAREN);
				setState(181);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				match(ID);
				setState(184);
				match(EQUALS);
				setState(185);
				expr(0);
				setState(186);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new ArrayAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				match(ID);
				setState(189);
				match(LSQUARE);
				setState(190);
				expr(0);
				setState(191);
				match(RSQUARE);
				setState(192);
				match(EQUALS);
				setState(193);
				expr(0);
				setState(194);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(196);
				match(RETURN);
				setState(197);
				expr(0);
				setState(198);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerExprContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(MiniJavaGrammarParser.INTEGER, 0); }
		public IntegerExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterIntegerExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitIntegerExpr(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitIdExpr(this);
		}
	}
	public static class MethodExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MiniJavaGrammarParser.DOT, 0); }
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniJavaGrammarParser.RPAREN, 0); }
		public ExprlistContext exprlist() {
			return getRuleContext(ExprlistContext.class,0);
		}
		public MethodExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterMethodExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitMethodExpr(this);
		}
	}
	public static class LengthExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MiniJavaGrammarParser.DOT, 0); }
		public TerminalNode LENGTH() { return getToken(MiniJavaGrammarParser.LENGTH, 0); }
		public LengthExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterLengthExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitLengthExpr(this);
		}
	}
	public static class NewArrExprContext extends ExprContext {
		public TerminalNode NEW() { return getToken(MiniJavaGrammarParser.NEW, 0); }
		public TerminalNode INT() { return getToken(MiniJavaGrammarParser.INT, 0); }
		public TerminalNode LSQUARE() { return getToken(MiniJavaGrammarParser.LSQUARE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQUARE() { return getToken(MiniJavaGrammarParser.RSQUARE, 0); }
		public NewArrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterNewArrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitNewArrExpr(this);
		}
	}
	public static class NewClassExprContext extends ExprContext {
		public TerminalNode NEW() { return getToken(MiniJavaGrammarParser.NEW, 0); }
		public TerminalNode ID() { return getToken(MiniJavaGrammarParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MiniJavaGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniJavaGrammarParser.RPAREN, 0); }
		public NewClassExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterNewClassExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitNewClassExpr(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(MiniJavaGrammarParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniJavaGrammarParser.RPAREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitParenExpr(this);
		}
	}
	public static class OpExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public OpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterOpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitOpExpr(this);
		}
	}
	public static class BooleanExprContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(MiniJavaGrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MiniJavaGrammarParser.FALSE, 0); }
		public TerminalNode NOT() { return getToken(MiniJavaGrammarParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BooleanExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterBooleanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitBooleanExpr(this);
		}
	}
	public static class ThisExprContext extends ExprContext {
		public TerminalNode THIS() { return getToken(MiniJavaGrammarParser.THIS, 0); }
		public ThisExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterThisExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitThisExpr(this);
		}
	}
	public static class IndexExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LSQUARE() { return getToken(MiniJavaGrammarParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(MiniJavaGrammarParser.RSQUARE, 0); }
		public IndexExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitIndexExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new IntegerExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(203);
				match(INTEGER);
				}
				break;
			case 2:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(TRUE);
				}
				break;
			case 3:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				match(FALSE);
				}
				break;
			case 4:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ThisExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				match(THIS);
				}
				break;
			case 6:
				{
				_localctx = new NewArrExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(NEW);
				setState(209);
				match(INT);
				setState(210);
				match(LSQUARE);
				setState(211);
				expr(0);
				setState(212);
				match(RSQUARE);
				}
				break;
			case 7:
				{
				_localctx = new NewClassExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(NEW);
				setState(215);
				match(ID);
				setState(216);
				match(LPAREN);
				setState(217);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new BooleanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				match(NOT);
				setState(219);
				expr(2);
				}
				break;
			case 9:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				match(LPAREN);
				setState(221);
				expr(0);
				setState(222);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(246);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(227);
						op();
						setState(228);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new IndexExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(231);
						match(LSQUARE);
						setState(232);
						expr(0);
						setState(233);
						match(RSQUARE);
						}
						break;
					case 3:
						{
						_localctx = new LengthExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(236);
						match(DOT);
						setState(237);
						match(LENGTH);
						}
						break;
					case 4:
						{
						_localctx = new MethodExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(238);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(239);
						match(DOT);
						setState(240);
						match(ID);
						setState(241);
						match(LPAREN);
						setState(243);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << THIS) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << LPAREN) | (1L << ID) | (1L << INTEGER))) != 0)) {
							{
							setState(242);
							exprlist();
							}
						}

						setState(245);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(MiniJavaGrammarParser.AND, 0); }
		public TerminalNode LT() { return getToken(MiniJavaGrammarParser.LT, 0); }
		public TerminalNode PLUS() { return getToken(MiniJavaGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MiniJavaGrammarParser.MINUS, 0); }
		public TerminalNode MUL() { return getToken(MiniJavaGrammarParser.MUL, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << LT) | (1L << PLUS) | (1L << MINUS) | (1L << MUL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprlistContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ExprrestContext> exprrest() {
			return getRuleContexts(ExprrestContext.class);
		}
		public ExprrestContext exprrest(int i) {
			return getRuleContext(ExprrestContext.class,i);
		}
		public ExprlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterExprlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitExprlist(this);
		}
	}

	public final ExprlistContext exprlist() throws RecognitionException {
		ExprlistContext _localctx = new ExprlistContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exprlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			expr(0);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(254);
				exprrest();
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprrestContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(MiniJavaGrammarParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprrestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprrest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).enterExprrest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaGrammarListener ) ((MiniJavaGrammarListener)listener).exitExprrest(this);
		}
	}

	public final ExprrestContext exprrest() throws RecognitionException {
		ExprrestContext _localctx = new ExprrestContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exprrest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(COMMA);
			setState(261);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f\2"+
		"\16\2&\13\2\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\7\3\63\n\3"+
		"\f\3\16\3\66\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5Q\n\5\f\5\16\5"+
		"T\13\5\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5c\n"+
		"\5\f\5\16\5f\13\5\3\5\7\5i\n\5\f\5\16\5l\13\5\3\5\5\5o\n\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\5\7z\n\7\3\7\3\7\3\7\7\7\177\n\7\f\7\16\7\u0082"+
		"\13\7\3\7\3\7\3\b\3\b\5\b\u0088\n\b\3\t\3\t\3\t\7\t\u008d\n\t\f\t\16\t"+
		"\u0090\13\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009c\n"+
		"\13\3\f\3\f\7\f\u00a0\n\f\f\f\16\f\u00a3\13\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00cb\n"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00e3\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00f6\n\r\3\r\7\r\u00f9\n\r\f\r\16"+
		"\r\u00fc\13\r\3\16\3\16\3\17\3\17\7\17\u0102\n\17\f\17\16\17\u0105\13"+
		"\17\3\20\3\20\3\20\3\20\2\3\30\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36\2\3\3\2\7\13\2\u011f\2 \3\2\2\2\4\'\3\2\2\2\69\3\2\2\2\bn\3\2\2\2"+
		"\np\3\2\2\2\ft\3\2\2\2\16\u0087\3\2\2\2\20\u0089\3\2\2\2\22\u0091\3\2"+
		"\2\2\24\u009b\3\2\2\2\26\u00ca\3\2\2\2\30\u00e2\3\2\2\2\32\u00fd\3\2\2"+
		"\2\34\u00ff\3\2\2\2\36\u0106\3\2\2\2 $\5\4\3\2!#\5\b\5\2\"!\3\2\2\2#&"+
		"\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\3\3\2\2\2&$\3\2\2\2\'(\7\f\2\2()\7*\2\2"+
		")-\7#\2\2*,\5\f\7\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2"+
		"\2/-\3\2\2\2\60\64\5\6\4\2\61\63\5\f\7\2\62\61\3\2\2\2\63\66\3\2\2\2\64"+
		"\62\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7$\2\28\5\3"+
		"\2\2\29:\7\r\2\2:;\7\16\2\2;<\7\17\2\2<=\7\20\2\2=>\7%\2\2>?\7\21\2\2"+
		"?@\7\'\2\2@A\7(\2\2AB\7*\2\2BC\7&\2\2CG\7#\2\2DF\5\16\b\2ED\3\2\2\2FI"+
		"\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7$\2\2K\7\3\2\2\2L"+
		"M\7\f\2\2MN\7*\2\2NR\7#\2\2OQ\5\n\6\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS"+
		"\3\2\2\2SX\3\2\2\2TR\3\2\2\2UW\5\f\7\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2X"+
		"Y\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[o\7$\2\2\\]\7\f\2\2]^\7*\2\2^_\7\22\2\2"+
		"_`\7*\2\2`d\7#\2\2ac\5\n\6\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e"+
		"j\3\2\2\2fd\3\2\2\2gi\5\f\7\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"km\3\2\2\2lj\3\2\2\2mo\7$\2\2nL\3\2\2\2n\\\3\2\2\2o\t\3\2\2\2pq\5\24\13"+
		"\2qr\7*\2\2rs\7\"\2\2s\13\3\2\2\2tu\7\r\2\2uv\5\24\13\2vw\7*\2\2wy\7%"+
		"\2\2xz\5\20\t\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7&\2\2|\u0080\7#\2\2}"+
		"\177\5\16\b\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7$\2\2\u0084"+
		"\r\3\2\2\2\u0085\u0088\5\n\6\2\u0086\u0088\5\26\f\2\u0087\u0085\3\2\2"+
		"\2\u0087\u0086\3\2\2\2\u0088\17\3\2\2\2\u0089\u008a\5\24\13\2\u008a\u008e"+
		"\7*\2\2\u008b\u008d\5\22\n\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\21\3\2\2\2\u0090\u008e\3\2\2"+
		"\2\u0091\u0092\7!\2\2\u0092\u0093\5\24\13\2\u0093\u0094\7*\2\2\u0094\23"+
		"\3\2\2\2\u0095\u0096\7\30\2\2\u0096\u0097\7\'\2\2\u0097\u009c\7(\2\2\u0098"+
		"\u009c\7\27\2\2\u0099\u009c\7\30\2\2\u009a\u009c\7*\2\2\u009b\u0095\3"+
		"\2\2\2\u009b\u0098\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c"+
		"\25\3\2\2\2\u009d\u00a1\7#\2\2\u009e\u00a0\5\26\f\2\u009f\u009e\3\2\2"+
		"\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4"+
		"\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00cb\7$\2\2\u00a5\u00a6\7\25\2\2\u00a6"+
		"\u00a7\7%\2\2\u00a7\u00a8\5\30\r\2\u00a8\u00a9\7&\2\2\u00a9\u00aa\5\26"+
		"\f\2\u00aa\u00ab\7\26\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00cb\3\2\2\2\u00ad"+
		"\u00ae\7\24\2\2\u00ae\u00af\7%\2\2\u00af\u00b0\5\30\r\2\u00b0\u00b1\7"+
		"&\2\2\u00b1\u00b2\5\26\f\2\u00b2\u00cb\3\2\2\2\u00b3\u00b4\7\31\2\2\u00b4"+
		"\u00b5\7%\2\2\u00b5\u00b6\5\30\r\2\u00b6\u00b7\7&\2\2\u00b7\u00b8\7\""+
		"\2\2\u00b8\u00cb\3\2\2\2\u00b9\u00ba\7*\2\2\u00ba\u00bb\7)\2\2\u00bb\u00bc"+
		"\5\30\r\2\u00bc\u00bd\7\"\2\2\u00bd\u00cb\3\2\2\2\u00be\u00bf\7*\2\2\u00bf"+
		"\u00c0\7\'\2\2\u00c0\u00c1\5\30\r\2\u00c1\u00c2\7(\2\2\u00c2\u00c3\7)"+
		"\2\2\u00c3\u00c4\5\30\r\2\u00c4\u00c5\7\"\2\2\u00c5\u00cb\3\2\2\2\u00c6"+
		"\u00c7\7\23\2\2\u00c7\u00c8\5\30\r\2\u00c8\u00c9\7\"\2\2\u00c9\u00cb\3"+
		"\2\2\2\u00ca\u009d\3\2\2\2\u00ca\u00a5\3\2\2\2\u00ca\u00ad\3\2\2\2\u00ca"+
		"\u00b3\3\2\2\2\u00ca\u00b9\3\2\2\2\u00ca\u00be\3\2\2\2\u00ca\u00c6\3\2"+
		"\2\2\u00cb\27\3\2\2\2\u00cc\u00cd\b\r\1\2\u00cd\u00e3\7,\2\2\u00ce\u00e3"+
		"\7\35\2\2\u00cf\u00e3\7\36\2\2\u00d0\u00e3\7*\2\2\u00d1\u00e3\7\34\2\2"+
		"\u00d2\u00d3\7\33\2\2\u00d3\u00d4\7\30\2\2\u00d4\u00d5\7\'\2\2\u00d5\u00d6"+
		"\5\30\r\2\u00d6\u00d7\7(\2\2\u00d7\u00e3\3\2\2\2\u00d8\u00d9\7\33\2\2"+
		"\u00d9\u00da\7*\2\2\u00da\u00db\7%\2\2\u00db\u00e3\7&\2\2\u00dc\u00dd"+
		"\7\37\2\2\u00dd\u00e3\5\30\r\4\u00de\u00df\7%\2\2\u00df\u00e0\5\30\r\2"+
		"\u00e0\u00e1\7&\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00cc\3\2\2\2\u00e2\u00ce"+
		"\3\2\2\2\u00e2\u00cf\3\2\2\2\u00e2\u00d0\3\2\2\2\u00e2\u00d1\3\2\2\2\u00e2"+
		"\u00d2\3\2\2\2\u00e2\u00d8\3\2\2\2\u00e2\u00dc\3\2\2\2\u00e2\u00de\3\2"+
		"\2\2\u00e3\u00fa\3\2\2\2\u00e4\u00e5\f\16\2\2\u00e5\u00e6\5\32\16\2\u00e6"+
		"\u00e7\5\30\r\17\u00e7\u00f9\3\2\2\2\u00e8\u00e9\f\17\2\2\u00e9\u00ea"+
		"\7\'\2\2\u00ea\u00eb\5\30\r\2\u00eb\u00ec\7(\2\2\u00ec\u00f9\3\2\2\2\u00ed"+
		"\u00ee\f\r\2\2\u00ee\u00ef\7 \2\2\u00ef\u00f9\7\32\2\2\u00f0\u00f1\f\f"+
		"\2\2\u00f1\u00f2\7 \2\2\u00f2\u00f3\7*\2\2\u00f3\u00f5\7%\2\2\u00f4\u00f6"+
		"\5\34\17\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2"+
		"\u00f7\u00f9\7&\2\2\u00f8\u00e4\3\2\2\2\u00f8\u00e8\3\2\2\2\u00f8\u00ed"+
		"\3\2\2\2\u00f8\u00f0\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\31\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\t\2\2"+
		"\2\u00fe\33\3\2\2\2\u00ff\u0103\5\30\r\2\u0100\u0102\5\36\20\2\u0101\u0100"+
		"\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\35\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107\7!\2\2\u0107\u0108\5\30\r"+
		"\2\u0108\37\3\2\2\2\27$-\64GRXdjny\u0080\u0087\u008e\u009b\u00a1\u00ca"+
		"\u00e2\u00f5\u00f8\u00fa\u0103";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}