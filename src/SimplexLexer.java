// Generated from /home/eduardo/Documents/Projects/simplex-language/simplex/SimplexLexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimplexLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, IF=2, ELSE=3, SWITCH=4, CASE=5, DEFAULT=6, WHILE=7, FOR=8, BREAK=9, 
		RETURN=10, DO=11, FUNCTION=12, ARROY=13, TYPE=14, STRUCT=15, STRING=16, 
		LITERAL_HEX=17, LITERAL_BIN=18, LITERAL_INT=19, LITERAL_FLOAT=20, LITERAL_STRING=21, 
		LITERAL_CHAR=22, DOT=23, COMMA=24, COLON=25, SEMICOLON=26, BRACKET_BEGIN=27, 
		BRACKET_END=28, BRACES_BEGIN=29, BRACES_END=30, PARENTHESES_BEGIN=31, 
		PARENTHESES_END=32, CARET=33, MINUS=34, PLUS=35, DIV=36, MUL=37, MOD=38, 
		LT=39, GT=40, LT_EQ=41, GT_EQ=42, EQ=43, DIFF=44, ASSIGN=45, AND=46, OR=47, 
		NOT=48, BIT_SHL=49, BIT_SHR=50, BIT_AND=51, BIT_OR=52, BIT_XOR=53, BIT_NOT=54, 
		SL_COMMENT=55, ML_COMMENT=56, ID=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "IF", "ELSE", "SWITCH", "CASE", "DEFAULT", "WHILE", "FOR", "BREAK", 
			"RETURN", "DO", "FUNCTION", "ARROY", "TYPE", "STRUCT", "STRING", "LITERAL_HEX", 
			"LITERAL_BIN", "LITERAL_INT", "LITERAL_FLOAT", "LITERAL_STRING", "LITERAL_CHAR", 
			"DOT", "COMMA", "COLON", "SEMICOLON", "BRACKET_BEGIN", "BRACKET_END", 
			"BRACES_BEGIN", "BRACES_END", "PARENTHESES_BEGIN", "PARENTHESES_END", 
			"CARET", "MINUS", "PLUS", "DIV", "MUL", "MOD", "LT", "GT", "LT_EQ", "GT_EQ", 
			"EQ", "DIFF", "ASSIGN", "AND", "OR", "NOT", "BIT_SHL", "BIT_SHR", "BIT_AND", 
			"BIT_OR", "BIT_XOR", "BIT_NOT", "SL_COMMENT", "ML_COMMENT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'if'", "'else'", "'switch'", "'case'", "'default'", "'while'", 
			"'for'", "'break'", "'return'", "'do'", "'fn'", "'->'", "'type'", "'struct'", 
			"'string'", null, null, null, null, "'\".*?\"'", null, "'.'", "','", 
			"':'", "';'", "'['", "']'", "'{'", "'}'", "'('", "')'", null, "'-'", 
			"'+'", "'/'", "'*'", "'%'", "'<'", "'>'", "'>='", "'<='", "'=='", "'!='", 
			"'='", "'&&'", "'||'", "'!'", "'<<'", "'>>'", "'&'", "'|'", null, "'~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "IF", "ELSE", "SWITCH", "CASE", "DEFAULT", "WHILE", "FOR", 
			"BREAK", "RETURN", "DO", "FUNCTION", "ARROY", "TYPE", "STRUCT", "STRING", 
			"LITERAL_HEX", "LITERAL_BIN", "LITERAL_INT", "LITERAL_FLOAT", "LITERAL_STRING", 
			"LITERAL_CHAR", "DOT", "COMMA", "COLON", "SEMICOLON", "BRACKET_BEGIN", 
			"BRACKET_END", "BRACES_BEGIN", "BRACES_END", "PARENTHESES_BEGIN", "PARENTHESES_END", 
			"CARET", "MINUS", "PLUS", "DIV", "MUL", "MOD", "LT", "GT", "LT_EQ", "GT_EQ", 
			"EQ", "DIFF", "ASSIGN", "AND", "OR", "NOT", "BIT_SHL", "BIT_SHR", "BIT_AND", 
			"BIT_OR", "BIT_XOR", "BIT_NOT", "SL_COMMENT", "ML_COMMENT", "ID"
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


	public SimplexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimplexLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u00009\u015c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u0001\u0000\u0004\u0000u\b"+
		"\u0000\u000b\u0000\f\u0000v\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0004\u0010\u00ce\b\u0010\u000b\u0010\f\u0010"+
		"\u00cf\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u00d6"+
		"\b\u0011\u000b\u0011\f\u0011\u00d7\u0001\u0012\u0004\u0012\u00db\b\u0012"+
		"\u000b\u0012\f\u0012\u00dc\u0001\u0013\u0004\u0013\u00e0\b\u0013\u000b"+
		"\u0013\f\u0013\u00e1\u0001\u0013\u0001\u0013\u0004\u0013\u00e6\b\u0013"+
		"\u000b\u0013\f\u0013\u00e7\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u00f3\b\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001+\u0001+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001-\u0001.\u0001"+
		".\u0001.\u0001/\u0001/\u00010\u00010\u00010\u00011\u00011\u00011\u0001"+
		"2\u00012\u00013\u00013\u00014\u00014\u00015\u00015\u00016\u00016\u0001"+
		"6\u00016\u00056\u0141\b6\n6\f6\u0144\t6\u00016\u00016\u00017\u00017\u0001"+
		"7\u00017\u00057\u014c\b7\n7\f7\u014f\t7\u00017\u00017\u00017\u00017\u0001"+
		"7\u00018\u00018\u00058\u0158\b8\n8\f8\u015b\t8\u0001\u014d\u00009\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K"+
		"&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g4i5k6m7o8q9\u0001\u0000\b\u0003\u0000\t\n"+
		"\r\r  \u0003\u000009AFaf\u0001\u000001\u0001\u000009\u0006\u0000\u001b"+
		"\u001b\\\\bbnnrrtt\u0002\u0000\n\n\r\r\u0002\u0000AZaz\u0004\u000009A"+
		"Z__az\u0165\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000"+
		"A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001"+
		"\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000"+
		"\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000"+
		"O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001"+
		"\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000"+
		"\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000"+
		"]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001"+
		"\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000"+
		"\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000\u0000\u0000\u0000"+
		"k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0000o\u0001"+
		"\u0000\u0000\u0000\u0000q\u0001\u0000\u0000\u0000\u0001t\u0001\u0000\u0000"+
		"\u0000\u0003z\u0001\u0000\u0000\u0000\u0005}\u0001\u0000\u0000\u0000\u0007"+
		"\u0082\u0001\u0000\u0000\u0000\t\u0089\u0001\u0000\u0000\u0000\u000b\u008e"+
		"\u0001\u0000\u0000\u0000\r\u0096\u0001\u0000\u0000\u0000\u000f\u009c\u0001"+
		"\u0000\u0000\u0000\u0011\u00a0\u0001\u0000\u0000\u0000\u0013\u00a6\u0001"+
		"\u0000\u0000\u0000\u0015\u00ad\u0001\u0000\u0000\u0000\u0017\u00b0\u0001"+
		"\u0000\u0000\u0000\u0019\u00b3\u0001\u0000\u0000\u0000\u001b\u00b6\u0001"+
		"\u0000\u0000\u0000\u001d\u00bb\u0001\u0000\u0000\u0000\u001f\u00c2\u0001"+
		"\u0000\u0000\u0000!\u00c9\u0001\u0000\u0000\u0000#\u00d1\u0001\u0000\u0000"+
		"\u0000%\u00da\u0001\u0000\u0000\u0000\'\u00df\u0001\u0000\u0000\u0000"+
		")\u00e9\u0001\u0000\u0000\u0000+\u00ef\u0001\u0000\u0000\u0000-\u00f4"+
		"\u0001\u0000\u0000\u0000/\u00f6\u0001\u0000\u0000\u00001\u00f8\u0001\u0000"+
		"\u0000\u00003\u00fa\u0001\u0000\u0000\u00005\u00fc\u0001\u0000\u0000\u0000"+
		"7\u00fe\u0001\u0000\u0000\u00009\u0100\u0001\u0000\u0000\u0000;\u0102"+
		"\u0001\u0000\u0000\u0000=\u0104\u0001\u0000\u0000\u0000?\u0106\u0001\u0000"+
		"\u0000\u0000A\u0108\u0001\u0000\u0000\u0000C\u010a\u0001\u0000\u0000\u0000"+
		"E\u010c\u0001\u0000\u0000\u0000G\u010e\u0001\u0000\u0000\u0000I\u0110"+
		"\u0001\u0000\u0000\u0000K\u0112\u0001\u0000\u0000\u0000M\u0114\u0001\u0000"+
		"\u0000\u0000O\u0116\u0001\u0000\u0000\u0000Q\u0118\u0001\u0000\u0000\u0000"+
		"S\u011b\u0001\u0000\u0000\u0000U\u011e\u0001\u0000\u0000\u0000W\u0121"+
		"\u0001\u0000\u0000\u0000Y\u0124\u0001\u0000\u0000\u0000[\u0126\u0001\u0000"+
		"\u0000\u0000]\u0129\u0001\u0000\u0000\u0000_\u012c\u0001\u0000\u0000\u0000"+
		"a\u012e\u0001\u0000\u0000\u0000c\u0131\u0001\u0000\u0000\u0000e\u0134"+
		"\u0001\u0000\u0000\u0000g\u0136\u0001\u0000\u0000\u0000i\u0138\u0001\u0000"+
		"\u0000\u0000k\u013a\u0001\u0000\u0000\u0000m\u013c\u0001\u0000\u0000\u0000"+
		"o\u0147\u0001\u0000\u0000\u0000q\u0155\u0001\u0000\u0000\u0000su\u0007"+
		"\u0000\u0000\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000"+
		"\u0000xy\u0006\u0000\u0000\u0000y\u0002\u0001\u0000\u0000\u0000z{\u0005"+
		"i\u0000\u0000{|\u0005f\u0000\u0000|\u0004\u0001\u0000\u0000\u0000}~\u0005"+
		"e\u0000\u0000~\u007f\u0005l\u0000\u0000\u007f\u0080\u0005s\u0000\u0000"+
		"\u0080\u0081\u0005e\u0000\u0000\u0081\u0006\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005s\u0000\u0000\u0083\u0084\u0005w\u0000\u0000\u0084\u0085\u0005"+
		"i\u0000\u0000\u0085\u0086\u0005t\u0000\u0000\u0086\u0087\u0005c\u0000"+
		"\u0000\u0087\u0088\u0005h\u0000\u0000\u0088\b\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0005c\u0000\u0000\u008a\u008b\u0005a\u0000\u0000\u008b\u008c"+
		"\u0005s\u0000\u0000\u008c\u008d\u0005e\u0000\u0000\u008d\n\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0005d\u0000\u0000\u008f\u0090\u0005e\u0000\u0000"+
		"\u0090\u0091\u0005f\u0000\u0000\u0091\u0092\u0005a\u0000\u0000\u0092\u0093"+
		"\u0005u\u0000\u0000\u0093\u0094\u0005l\u0000\u0000\u0094\u0095\u0005t"+
		"\u0000\u0000\u0095\f\u0001\u0000\u0000\u0000\u0096\u0097\u0005w\u0000"+
		"\u0000\u0097\u0098\u0005h\u0000\u0000\u0098\u0099\u0005i\u0000\u0000\u0099"+
		"\u009a\u0005l\u0000\u0000\u009a\u009b\u0005e\u0000\u0000\u009b\u000e\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0005f\u0000\u0000\u009d\u009e\u0005o\u0000"+
		"\u0000\u009e\u009f\u0005r\u0000\u0000\u009f\u0010\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0005b\u0000\u0000\u00a1\u00a2\u0005r\u0000\u0000\u00a2\u00a3"+
		"\u0005e\u0000\u0000\u00a3\u00a4\u0005a\u0000\u0000\u00a4\u00a5\u0005k"+
		"\u0000\u0000\u00a5\u0012\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005r\u0000"+
		"\u0000\u00a7\u00a8\u0005e\u0000\u0000\u00a8\u00a9\u0005t\u0000\u0000\u00a9"+
		"\u00aa\u0005u\u0000\u0000\u00aa\u00ab\u0005r\u0000\u0000\u00ab\u00ac\u0005"+
		"n\u0000\u0000\u00ac\u0014\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005d\u0000"+
		"\u0000\u00ae\u00af\u0005o\u0000\u0000\u00af\u0016\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0005f\u0000\u0000\u00b1\u00b2\u0005n\u0000\u0000\u00b2\u0018"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005-\u0000\u0000\u00b4\u00b5\u0005"+
		">\u0000\u0000\u00b5\u001a\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005t\u0000"+
		"\u0000\u00b7\u00b8\u0005y\u0000\u0000\u00b8\u00b9\u0005p\u0000\u0000\u00b9"+
		"\u00ba\u0005e\u0000\u0000\u00ba\u001c\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0005s\u0000\u0000\u00bc\u00bd\u0005t\u0000\u0000\u00bd\u00be\u0005r"+
		"\u0000\u0000\u00be\u00bf\u0005u\u0000\u0000\u00bf\u00c0\u0005c\u0000\u0000"+
		"\u00c0\u00c1\u0005t\u0000\u0000\u00c1\u001e\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0005s\u0000\u0000\u00c3\u00c4\u0005t\u0000\u0000\u00c4\u00c5\u0005"+
		"r\u0000\u0000\u00c5\u00c6\u0005i\u0000\u0000\u00c6\u00c7\u0005n\u0000"+
		"\u0000\u00c7\u00c8\u0005g\u0000\u0000\u00c8 \u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u00050\u0000\u0000\u00ca\u00cb\u0005x\u0000\u0000\u00cb\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cc\u00ce\u0007\u0001\u0000\u0000\u00cd\u00cc\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\"\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u00050\u0000\u0000\u00d2\u00d3\u0005b\u0000\u0000"+
		"\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u00d6\u0007\u0002\u0000\u0000"+
		"\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000"+
		"\u00d8$\u0001\u0000\u0000\u0000\u00d9\u00db\u0007\u0003\u0000\u0000\u00da"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd"+
		"&\u0001\u0000\u0000\u0000\u00de\u00e0\u0007\u0003\u0000\u0000\u00df\u00de"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00df"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e5\u0005.\u0000\u0000\u00e4\u00e6\u0007"+
		"\u0003\u0000\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001"+
		"\u0000\u0000\u0000\u00e8(\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\""+
		"\u0000\u0000\u00ea\u00eb\u0005.\u0000\u0000\u00eb\u00ec\u0005*\u0000\u0000"+
		"\u00ec\u00ed\u0005?\u0000\u0000\u00ed\u00ee\u0005\"\u0000\u0000\u00ee"+
		"*\u0001\u0000\u0000\u0000\u00ef\u00f2\u0005\\\u0000\u0000\u00f0\u00f3"+
		"\u0007\u0004\u0000\u0000\u00f1\u00f3\t\u0000\u0000\u0000\u00f2\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3,\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f5\u0005.\u0000\u0000\u00f5.\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f7\u0005,\u0000\u0000\u00f70\u0001\u0000\u0000\u0000\u00f8\u00f9"+
		"\u0005:\u0000\u0000\u00f92\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005;"+
		"\u0000\u0000\u00fb4\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005[\u0000\u0000"+
		"\u00fd6\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005]\u0000\u0000\u00ff8"+
		"\u0001\u0000\u0000\u0000\u0100\u0101\u0005{\u0000\u0000\u0101:\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0005}\u0000\u0000\u0103<\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0005(\u0000\u0000\u0105>\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0005)\u0000\u0000\u0107@\u0001\u0000\u0000\u0000\u0108\u0109\u0005^"+
		"\u0000\u0000\u0109B\u0001\u0000\u0000\u0000\u010a\u010b\u0005-\u0000\u0000"+
		"\u010bD\u0001\u0000\u0000\u0000\u010c\u010d\u0005+\u0000\u0000\u010dF"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0005/\u0000\u0000\u010fH\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0005*\u0000\u0000\u0111J\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0005%\u0000\u0000\u0113L\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0005<\u0000\u0000\u0115N\u0001\u0000\u0000\u0000\u0116\u0117\u0005>"+
		"\u0000\u0000\u0117P\u0001\u0000\u0000\u0000\u0118\u0119\u0005>\u0000\u0000"+
		"\u0119\u011a\u0005=\u0000\u0000\u011aR\u0001\u0000\u0000\u0000\u011b\u011c"+
		"\u0005<\u0000\u0000\u011c\u011d\u0005=\u0000\u0000\u011dT\u0001\u0000"+
		"\u0000\u0000\u011e\u011f\u0005=\u0000\u0000\u011f\u0120\u0005=\u0000\u0000"+
		"\u0120V\u0001\u0000\u0000\u0000\u0121\u0122\u0005!\u0000\u0000\u0122\u0123"+
		"\u0005=\u0000\u0000\u0123X\u0001\u0000\u0000\u0000\u0124\u0125\u0005="+
		"\u0000\u0000\u0125Z\u0001\u0000\u0000\u0000\u0126\u0127\u0005&\u0000\u0000"+
		"\u0127\u0128\u0005&\u0000\u0000\u0128\\\u0001\u0000\u0000\u0000\u0129"+
		"\u012a\u0005|\u0000\u0000\u012a\u012b\u0005|\u0000\u0000\u012b^\u0001"+
		"\u0000\u0000\u0000\u012c\u012d\u0005!\u0000\u0000\u012d`\u0001\u0000\u0000"+
		"\u0000\u012e\u012f\u0005<\u0000\u0000\u012f\u0130\u0005<\u0000\u0000\u0130"+
		"b\u0001\u0000\u0000\u0000\u0131\u0132\u0005>\u0000\u0000\u0132\u0133\u0005"+
		">\u0000\u0000\u0133d\u0001\u0000\u0000\u0000\u0134\u0135\u0005&\u0000"+
		"\u0000\u0135f\u0001\u0000\u0000\u0000\u0136\u0137\u0005|\u0000\u0000\u0137"+
		"h\u0001\u0000\u0000\u0000\u0138\u0139\u0005^\u0000\u0000\u0139j\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0005~\u0000\u0000\u013bl\u0001\u0000\u0000"+
		"\u0000\u013c\u013d\u0005/\u0000\u0000\u013d\u013e\u0005/\u0000\u0000\u013e"+
		"\u0142\u0001\u0000\u0000\u0000\u013f\u0141\b\u0005\u0000\u0000\u0140\u013f"+
		"\u0001\u0000\u0000\u0000\u0141\u0144\u0001\u0000\u0000\u0000\u0142\u0140"+
		"\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0145"+
		"\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0145\u0146"+
		"\u00066\u0000\u0000\u0146n\u0001\u0000\u0000\u0000\u0147\u0148\u0005/"+
		"\u0000\u0000\u0148\u0149\u0005*\u0000\u0000\u0149\u014d\u0001\u0000\u0000"+
		"\u0000\u014a\u014c\t\u0000\u0000\u0000\u014b\u014a\u0001\u0000\u0000\u0000"+
		"\u014c\u014f\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000"+
		"\u014d\u014b\u0001\u0000\u0000\u0000\u014e\u0150\u0001\u0000\u0000\u0000"+
		"\u014f\u014d\u0001\u0000\u0000\u0000\u0150\u0151\u0005*\u0000\u0000\u0151"+
		"\u0152\u0005/\u0000\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0154"+
		"\u00067\u0000\u0000\u0154p\u0001\u0000\u0000\u0000\u0155\u0159\u0007\u0006"+
		"\u0000\u0000\u0156\u0158\u0007\u0007\u0000\u0000\u0157\u0156\u0001\u0000"+
		"\u0000\u0000\u0158\u015b\u0001\u0000\u0000\u0000\u0159\u0157\u0001\u0000"+
		"\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015ar\u0001\u0000\u0000"+
		"\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u000b\u0000v\u00cf\u00d7\u00dc"+
		"\u00e1\u00e7\u00f2\u0142\u014d\u0159\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}