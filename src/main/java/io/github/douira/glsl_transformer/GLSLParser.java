// Generated from java-escape by ANTLR 4.11.1
package io.github.douira.glsl_transformer;

import io.github.douira.glsl_transformer.parser.ExtendedParser;
import repack.antlr.v4.runtime.*;
import repack.antlr.v4.runtime.atn.ATN;
import repack.antlr.v4.runtime.atn.ATNDeserializer;
import repack.antlr.v4.runtime.atn.ParserATNSimulator;
import repack.antlr.v4.runtime.atn.PredictionContextCache;
import repack.antlr.v4.runtime.dfa.DFA;
import repack.antlr.v4.runtime.tree.ParseTreeListener;
import repack.antlr.v4.runtime.tree.ParseTreeVisitor;
import repack.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GLSLParser extends ExtendedParser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, UNIFORM=2, BUFFER=3, IN=4, OUT=5, INOUT=6, HIGHP=7, MEDIUMP=8,
		LOWP=9, PRECISION=10, CONST=11, PRECISE=12, INVARIANT=13, SMOOTH=14, FLAT=15,
		CENTROID=16, ATTRIBUTE=17, VOLATILE=18, VARYING=19, SHARED=20, LAYOUT=21,
		DOT_LENGTH_METHOD_CALL=22, NOPERSPECTIVE=23, SAMPLE=24, PATCH=25, COHERENT=26,
		RESTRICT=27, READONLY=28, WRITEONLY=29, SUBROUTINE=30, DEVICECOHERENT=31,
		QUEUEFAMILYCOHERENT=32, WORKGROUPCOHERENT=33, SUBGROUPCOHERENT=34, NONPRIVATE=35,
		RAY_PAYLOAD_EXT=36, RAY_PAYLOAD_IN_EXT=37, HIT_ATTRIBUTE_EXT=38, CALLABLE_DATA_EXT=39,
		CALLABLE_DATA_IN_EXT=40, IGNORE_INTERSECTION_EXT=41, TERMINATE_RAY_EXT=42,
		ACCELERATION_STRUCTURE_EXT=43, ATOMIC_UINT=44, STRUCT=45, IF=46, ELSE=47,
		SWITCH=48, CASE=49, DEFAULT=50, WHILE=51, DO=52, FOR=53, CONTINUE=54,
		BREAK=55, RETURN=56, DISCARD=57, DEMOTE=58, UINT16CONSTANT=59, INT16CONSTANT=60,
		UINT32CONSTANT=61, INT32CONSTANT=62, UINT64CONSTANT=63, INT64CONSTANT=64,
		FLOAT16CONSTANT=65, FLOAT32CONSTANT=66, FLOAT64CONSTANT=67, BOOLCONSTANT=68,
		BOOL=69, BVEC2=70, BVEC3=71, BVEC4=72, INT8=73, I8VEC2=74, I8VEC3=75,
		I8VEC4=76, UINT8=77, U8VEC2=78, U8VEC3=79, U8VEC4=80, INT16=81, I16VEC2=82,
		I16VEC3=83, I16VEC4=84, UINT16=85, U16VEC2=86, U16VEC3=87, U16VEC4=88,
		INT32=89, I32VEC2=90, I32VEC3=91, I32VEC4=92, UINT32=93, U32VEC2=94, U32VEC3=95,
		U32VEC4=96, INT64=97, I64VEC2=98, I64VEC3=99, I64VEC4=100, UINT64=101,
		U64VEC2=102, U64VEC3=103, U64VEC4=104, FLOAT16=105, F16VEC2=106, F16VEC3=107,
		F16VEC4=108, F16MAT2X2=109, F16MAT2X3=110, F16MAT2X4=111, F16MAT3X2=112,
		F16MAT3X3=113, F16MAT3X4=114, F16MAT4X2=115, F16MAT4X3=116, F16MAT4X4=117,
		FLOAT32=118, F32VEC2=119, F32VEC3=120, F32VEC4=121, F32MAT2X2=122, F32MAT2X3=123,
		F32MAT2X4=124, F32MAT3X2=125, F32MAT3X3=126, F32MAT3X4=127, F32MAT4X2=128,
		F32MAT4X3=129, F32MAT4X4=130, FLOAT64=131, F64VEC2=132, F64VEC3=133, F64VEC4=134,
		F64MAT2X2=135, F64MAT2X3=136, F64MAT2X4=137, F64MAT3X2=138, F64MAT3X3=139,
		F64MAT3X4=140, F64MAT4X2=141, F64MAT4X3=142, F64MAT4X4=143, IMAGE1D=144,
		IMAGE2D=145, IMAGE3D=146, UIMAGE1D=147, UIMAGE2D=148, UIMAGE3D=149, IIMAGE1D=150,
		IIMAGE2D=151, IIMAGE3D=152, SAMPLER1D=153, SAMPLER2D=154, SAMPLER3D=155,
		SAMPLER2DRECT=156, SAMPLER1DSHADOW=157, SAMPLER2DSHADOW=158, SAMPLER2DRECTSHADOW=159,
		SAMPLER1DARRAY=160, SAMPLER2DARRAY=161, SAMPLER1DARRAYSHADOW=162, SAMPLER2DARRAYSHADOW=163,
		ISAMPLER1D=164, ISAMPLER2D=165, ISAMPLER2DRECT=166, ISAMPLER3D=167, ISAMPLER1DARRAY=168,
		ISAMPLER2DARRAY=169, USAMPLER1D=170, USAMPLER2D=171, USAMPLER2DRECT=172,
		USAMPLER3D=173, USAMPLER1DARRAY=174, USAMPLER2DARRAY=175, SAMPLER2DMS=176,
		ISAMPLER2DMS=177, USAMPLER2DMS=178, SAMPLER2DMSARRAY=179, ISAMPLER2DMSARRAY=180,
		USAMPLER2DMSARRAY=181, IMAGE2DRECT=182, IMAGE1DARRAY=183, IMAGE2DARRAY=184,
		IMAGE2DMS=185, IMAGE2DMSARRAY=186, IIMAGE2DRECT=187, IIMAGE1DARRAY=188,
		IIMAGE2DARRAY=189, IIMAGE2DMS=190, IIMAGE2DMSARRAY=191, UIMAGE2DRECT=192,
		UIMAGE1DARRAY=193, UIMAGE2DARRAY=194, UIMAGE2DMS=195, UIMAGE2DMSARRAY=196,
		SAMPLERCUBESHADOW=197, SAMPLERCUBEARRAYSHADOW=198, SAMPLERCUBE=199, ISAMPLERCUBE=200,
		USAMPLERCUBE=201, SAMPLERBUFFER=202, ISAMPLERBUFFER=203, USAMPLERBUFFER=204,
		SAMPLERCUBEARRAY=205, ISAMPLERCUBEARRAY=206, USAMPLERCUBEARRAY=207, IMAGECUBE=208,
		UIMAGECUBE=209, IIMAGECUBE=210, IMAGEBUFFER=211, IIMAGEBUFFER=212, UIMAGEBUFFER=213,
		IMAGECUBEARRAY=214, IIMAGECUBEARRAY=215, UIMAGECUBEARRAY=216, INC_OP=217,
		DEC_OP=218, VOID=219, LEFT_OP=220, RIGHT_OP=221, LE_OP=222, GE_OP=223,
		EQ_OP=224, NE_OP=225, LOGICAL_AND_OP=226, LOGICAL_XOR_OP=227, LOGICAL_OR_OP=228,
		MUL_ASSIGN=229, DIV_ASSIGN=230, MOD_ASSIGN=231, ADD_ASSIGN=232, SUB_ASSIGN=233,
		LEFT_ASSIGN=234, RIGHT_ASSIGN=235, AND_ASSIGN=236, XOR_ASSIGN=237, OR_ASSIGN=238,
		LPAREN=239, RPAREN=240, LBRACE=241, RBRACE=242, SEMICOLON=243, LBRACKET=244,
		RBRACKET=245, COMMA=246, DOT=247, PLUS_OP=248, MINUS_OP=249, LOGICAL_NOT_OP=250,
		BITWISE_NEG_OP=251, TIMES_OP=252, DIV_OP=253, MOD_OP=254, LT_OP=255, GT_OP=256,
		BITWISE_AND_OP=257, BITWISE_OR_OP=258, BITWISE_XOR_OP=259, QUERY_OP=260,
		ASSIGN_OP=261, PP_ENTER_MODE=262, PP_EMPTY=263, NR_LINE=264, NR=265, IDENTIFIER=266,
		LINE_CONTINUE=267, LINE_COMMENT=268, BLOCK_COMMENT=269, WS=270, EOL=271,
		NR_EXTENSION=272, NR_VERSION=273, NR_CUSTOM=274, NR_INCLUDE=275, NR_PRAGMA=276,
		NR_PRAGMA_DEBUG=277, NR_PRAGMA_OPTIMIZE=278, NR_PRAGMA_INVARIANT=279,
		NR_ON=280, NR_OFF=281, NR_ALL=282, NR_REQUIRE=283, NR_ENABLE=284, NR_WARN=285,
		NR_DISABLE=286, NR_COLON=287, NR_LPAREN=288, NR_RPAREN=289, NR_STDGL=290,
		NR_CORE=291, NR_COMPATIBILITY=292, NR_ES=293, NR_GLSL_110=294, NR_GLSL_120=295,
		NR_GLSLES_100=296, NR_GLSL_130=297, NR_GLSL_140=298, NR_GLSL_150=299,
		NR_GLSL_330=300, NR_GLSLES_300=301, NR_GLSLES_310=302, NR_GLSLES_320=303,
		NR_GLSL_400=304, NR_GLSL_410=305, NR_GLSL_420=306, NR_GLSL_430=307, NR_GLSL_440=308,
		NR_GLSL_450=309, NR_GLSL_460=310, NR_STRING_START=311, NR_STRING_START_ANGLE=312,
		NR_INTCONSTANT=313, NR_IDENTIFIER=314, NR_LINE_CONTINUE=315, NR_LINE_COMMENT=316,
		NR_BLOCK_COMMENT=317, NR_EOL=318, NR_WS=319, S_CONTENT=320, S_STRING_END=321,
		S_CONTENT_ANGLE=322, S_STRING_END_ANGLE=323, C_LINE_COMMENT=324, C_BLOCK_COMMENT=325,
		C_EOL=326, C_WS=327, C_CONTENT=328, PP_LINE_CONTINUE=329, PP_LINE_COMMENT=330,
		PP_BLOCK_COMMENT=331, PP_EOL=332, PP_CONTENT=333;
	public static final int
		RULE_translationUnit = 0, RULE_versionStatement = 1, RULE_externalDeclaration = 2,
		RULE_emptyDeclaration = 3, RULE_pragmaDirective = 4, RULE_extensionDirective = 5,
		RULE_customDirective = 6, RULE_includeDirective = 7, RULE_layoutDefaults = 8,
		RULE_functionDefinition = 9, RULE_finiteExpression = 10, RULE_expression = 11,
		RULE_declaration = 12, RULE_functionPrototype = 13, RULE_functionParameterList = 14,
		RULE_parameterDeclaration = 15, RULE_attribute = 16, RULE_singleAttribute = 17,
		RULE_declarationMember = 18, RULE_fullySpecifiedType = 19, RULE_storageQualifier = 20,
		RULE_layoutQualifier = 21, RULE_layoutQualifierId = 22, RULE_precisionQualifier = 23,
		RULE_interpolationQualifier = 24, RULE_invariantQualifier = 25, RULE_preciseQualifier = 26,
		RULE_typeQualifier = 27, RULE_typeSpecifier = 28, RULE_arraySpecifier = 29,
		RULE_arraySpecifierSegment = 30, RULE_builtinTypeSpecifierParseable = 31,
		RULE_builtinTypeSpecifierFixed = 32, RULE_structSpecifier = 33, RULE_structBody = 34,
		RULE_structMember = 35, RULE_structDeclarator = 36, RULE_initializer = 37,
		RULE_statement = 38, RULE_compoundStatement = 39, RULE_declarationStatement = 40,
		RULE_expressionStatement = 41, RULE_emptyStatement = 42, RULE_selectionStatement = 43,
		RULE_iterationCondition = 44, RULE_switchStatement = 45, RULE_caseLabel = 46,
		RULE_whileStatement = 47, RULE_doWhileStatement = 48, RULE_forStatement = 49,
		RULE_jumpStatement = 50, RULE_demoteStatement = 51;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "versionStatement", "externalDeclaration", "emptyDeclaration",
			"pragmaDirective", "extensionDirective", "customDirective", "includeDirective",
			"layoutDefaults", "functionDefinition", "finiteExpression", "expression",
			"declaration", "functionPrototype", "functionParameterList", "parameterDeclaration",
			"attribute", "singleAttribute", "declarationMember", "fullySpecifiedType",
			"storageQualifier", "layoutQualifier", "layoutQualifierId", "precisionQualifier",
			"interpolationQualifier", "invariantQualifier", "preciseQualifier", "typeQualifier",
			"typeSpecifier", "arraySpecifier", "arraySpecifierSegment", "builtinTypeSpecifierParseable",
			"builtinTypeSpecifierFixed", "structSpecifier", "structBody", "structMember",
			"structDeclarator", "initializer", "statement", "compoundStatement",
			"declarationStatement", "expressionStatement", "emptyStatement", "selectionStatement",
			"iterationCondition", "switchStatement", "caseLabel", "whileStatement",
			"doWhileStatement", "forStatement", "jumpStatement", "demoteStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'uniform'", "'buffer'", "'in'", "'out'", "'inout'", "'highp'",
			"'mediump'", "'lowp'", "'precision'", "'const'", "'precise'", null, "'smooth'",
			"'flat'", "'centroid'", "'attribute'", "'volatile'", "'varying'", "'shared'",
			"'layout'", "'.length()'", "'noperspective'", "'sample'", "'patch'",
			"'coherent'", "'restrict'", "'readonly'", "'writeonly'", "'subroutine'",
			"'devicecoherent'", "'queuefamilycoherent'", "'workgroupcoherent'", "'subgroupcoherent'",
			"'nonprivate'", "'rayPayloadEXT'", "'rayPayloadInEXT'", "'hitAttributeEXT'",
			"'callableDataEXT'", "'callableDataInEXT'", "'ignoreIntersectionEXT'",
			"'terminateRayEXT'", "'accelerationStructureEXT'", "'atomic_uint'", "'struct'",
			"'if'", "'else'", "'switch'", "'case'", "'default'", "'while'", "'do'",
			"'for'", "'continue'", "'break'", "'return'", "'discard'", "'demote'",
			null, null, null, null, null, null, null, null, null, null, "'bool'",
			"'bvec2'", "'bvec3'", "'bvec4'", "'int8_t'", "'i8vec2'", "'i8vec3'",
			"'i8vec4'", "'uint8_t'", "'u8vec2'", "'u8vec3'", "'u8vec4'", "'int16_t'",
			"'i16vec2'", "'i16vec3'", "'i16vec4'", "'uint16_t'", "'u16vec2'", "'u16vec3'",
			"'u16vec4'", null, null, null, null, null, null, null, null, "'int64_t'",
			"'i64vec2'", "'i64vec3'", "'i64vec4'", "'uint64_t'", "'u64vec2'", "'u64vec3'",
			"'u64vec4'", "'float16_t'", "'f16vec2'", "'f16vec3'", "'f16vec4'", null,
			"'f16mat2x3'", "'f16mat2x4'", "'f16mat3x2'", null, "'f16mat3x4'", "'f16mat4x2'",
			"'f16mat4x3'", null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, "'image1D'", "'image2D'", "'image3D'",
			"'uimage1D'", "'uimage2D'", "'uimage3D'", "'iimage1D'", "'iimage2D'",
			"'iimage3D'", "'sampler1D'", "'sampler2D'", "'sampler3D'", "'sampler2DRect'",
			"'sampler1DShadow'", "'sampler2DShadow'", "'sampler2DRectShadow'", "'sampler1DArray'",
			"'sampler2DArray'", "'sampler1DArrayShadow'", "'sampler2DArrayShadow'",
			"'isampler1D'", "'isampler2D'", "'isampler2DRect'", "'isampler3D'", "'isampler1DArray'",
			"'isampler2DArray'", "'usampler1D'", "'usampler2D'", "'usampler2DRect'",
			"'usampler3D'", "'usampler1DArray'", "'usampler2DArray'", "'sampler2DMS'",
			"'isampler2DMS'", "'usampler2DMS'", "'sampler2DMSArray'", "'isampler2DMSArray'",
			"'usampler2DMSArray'", "'image2DRect'", "'image1DArray'", "'image2DArray'",
			"'image2DMS'", "'image2DMSArray'", "'iimage2DRect'", "'iimage1DArray'",
			"'iimage2DArray'", "'iimage2DMS'", "'iimage2DMSArray'", "'uimage2DRect'",
			"'uimage1DArray'", "'uimage2DArray'", "'uimage2DMS'", "'uimage2DMSArray'",
			"'samplerCubeShadow'", "'samplerCubeArrayShadow'", "'samplerCube'", "'isamplerCube'",
			"'usamplerCube'", "'samplerBuffer'", "'isamplerBuffer'", "'usamplerBuffer'",
			"'samplerCubeArray'", "'isamplerCubeArray'", "'usamplerCubeArray'", "'imageCube'",
			"'uimageCube'", "'iimageCube'", "'imageBuffer'", "'iimageBuffer'", "'uimageBuffer'",
			"'imageCubeArray'", "'iimageCubeArray'", "'uimageCubeArray'", "'++'",
			"'--'", "'void'", "'<<'", "'>>'", "'<='", "'>='", "'=='", "'!='", "'&&'",
			"'^^'", "'||'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='",
			"'&='", "'^='", "'|='", null, null, "'{'", "'}'", "';'", "'['", "']'",
			"','", "'.'", "'+'", "'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'<'",
			null, "'&'", "'|'", "'^'", "'?'", "'='", null, null, null, "'#'", null,
			null, null, null, null, null, "'extension'", "'version'", null, "'include'",
			"'pragma'", "'debug'", "'optimize'", null, "'on'", "'off'", "'all'",
			"'require'", "'enable'", "'warn'", "'disable'", null, null, null, "'STDGL'",
			"'core'", "'compatibility'", "'es'", "'110'", "'120'", "'100'", "'130'",
			"'140'", "'150'", "'330'", "'300'", "'310'", "'320'", "'400'", "'410'",
			"'420'", "'430'", "'440'", "'450'", "'460'", null, null, null, null,
			null, null, null, null, null, null, "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COLON", "UNIFORM", "BUFFER", "IN", "OUT", "INOUT", "HIGHP", "MEDIUMP",
			"LOWP", "PRECISION", "CONST", "PRECISE", "INVARIANT", "SMOOTH", "FLAT",
			"CENTROID", "ATTRIBUTE", "VOLATILE", "VARYING", "SHARED", "LAYOUT", "DOT_LENGTH_METHOD_CALL",
			"NOPERSPECTIVE", "SAMPLE", "PATCH", "COHERENT", "RESTRICT", "READONLY",
			"WRITEONLY", "SUBROUTINE", "DEVICECOHERENT", "QUEUEFAMILYCOHERENT", "WORKGROUPCOHERENT",
			"SUBGROUPCOHERENT", "NONPRIVATE", "RAY_PAYLOAD_EXT", "RAY_PAYLOAD_IN_EXT",
			"HIT_ATTRIBUTE_EXT", "CALLABLE_DATA_EXT", "CALLABLE_DATA_IN_EXT", "IGNORE_INTERSECTION_EXT",
			"TERMINATE_RAY_EXT", "ACCELERATION_STRUCTURE_EXT", "ATOMIC_UINT", "STRUCT",
			"IF", "ELSE", "SWITCH", "CASE", "DEFAULT", "WHILE", "DO", "FOR", "CONTINUE",
			"BREAK", "RETURN", "DISCARD", "DEMOTE", "UINT16CONSTANT", "INT16CONSTANT",
			"UINT32CONSTANT", "INT32CONSTANT", "UINT64CONSTANT", "INT64CONSTANT",
			"FLOAT16CONSTANT", "FLOAT32CONSTANT", "FLOAT64CONSTANT", "BOOLCONSTANT",
			"BOOL", "BVEC2", "BVEC3", "BVEC4", "INT8", "I8VEC2", "I8VEC3", "I8VEC4",
			"UINT8", "U8VEC2", "U8VEC3", "U8VEC4", "INT16", "I16VEC2", "I16VEC3",
			"I16VEC4", "UINT16", "U16VEC2", "U16VEC3", "U16VEC4", "INT32", "I32VEC2",
			"I32VEC3", "I32VEC4", "UINT32", "U32VEC2", "U32VEC3", "U32VEC4", "INT64",
			"I64VEC2", "I64VEC3", "I64VEC4", "UINT64", "U64VEC2", "U64VEC3", "U64VEC4",
			"FLOAT16", "F16VEC2", "F16VEC3", "F16VEC4", "F16MAT2X2", "F16MAT2X3",
			"F16MAT2X4", "F16MAT3X2", "F16MAT3X3", "F16MAT3X4", "F16MAT4X2", "F16MAT4X3",
			"F16MAT4X4", "FLOAT32", "F32VEC2", "F32VEC3", "F32VEC4", "F32MAT2X2",
			"F32MAT2X3", "F32MAT2X4", "F32MAT3X2", "F32MAT3X3", "F32MAT3X4", "F32MAT4X2",
			"F32MAT4X3", "F32MAT4X4", "FLOAT64", "F64VEC2", "F64VEC3", "F64VEC4",
			"F64MAT2X2", "F64MAT2X3", "F64MAT2X4", "F64MAT3X2", "F64MAT3X3", "F64MAT3X4",
			"F64MAT4X2", "F64MAT4X3", "F64MAT4X4", "IMAGE1D", "IMAGE2D", "IMAGE3D",
			"UIMAGE1D", "UIMAGE2D", "UIMAGE3D", "IIMAGE1D", "IIMAGE2D", "IIMAGE3D",
			"SAMPLER1D", "SAMPLER2D", "SAMPLER3D", "SAMPLER2DRECT", "SAMPLER1DSHADOW",
			"SAMPLER2DSHADOW", "SAMPLER2DRECTSHADOW", "SAMPLER1DARRAY", "SAMPLER2DARRAY",
			"SAMPLER1DARRAYSHADOW", "SAMPLER2DARRAYSHADOW", "ISAMPLER1D", "ISAMPLER2D",
			"ISAMPLER2DRECT", "ISAMPLER3D", "ISAMPLER1DARRAY", "ISAMPLER2DARRAY",
			"USAMPLER1D", "USAMPLER2D", "USAMPLER2DRECT", "USAMPLER3D", "USAMPLER1DARRAY",
			"USAMPLER2DARRAY", "SAMPLER2DMS", "ISAMPLER2DMS", "USAMPLER2DMS", "SAMPLER2DMSARRAY",
			"ISAMPLER2DMSARRAY", "USAMPLER2DMSARRAY", "IMAGE2DRECT", "IMAGE1DARRAY",
			"IMAGE2DARRAY", "IMAGE2DMS", "IMAGE2DMSARRAY", "IIMAGE2DRECT", "IIMAGE1DARRAY",
			"IIMAGE2DARRAY", "IIMAGE2DMS", "IIMAGE2DMSARRAY", "UIMAGE2DRECT", "UIMAGE1DARRAY",
			"UIMAGE2DARRAY", "UIMAGE2DMS", "UIMAGE2DMSARRAY", "SAMPLERCUBESHADOW",
			"SAMPLERCUBEARRAYSHADOW", "SAMPLERCUBE", "ISAMPLERCUBE", "USAMPLERCUBE",
			"SAMPLERBUFFER", "ISAMPLERBUFFER", "USAMPLERBUFFER", "SAMPLERCUBEARRAY",
			"ISAMPLERCUBEARRAY", "USAMPLERCUBEARRAY", "IMAGECUBE", "UIMAGECUBE",
			"IIMAGECUBE", "IMAGEBUFFER", "IIMAGEBUFFER", "UIMAGEBUFFER", "IMAGECUBEARRAY",
			"IIMAGECUBEARRAY", "UIMAGECUBEARRAY", "INC_OP", "DEC_OP", "VOID", "LEFT_OP",
			"RIGHT_OP", "LE_OP", "GE_OP", "EQ_OP", "NE_OP", "LOGICAL_AND_OP", "LOGICAL_XOR_OP",
			"LOGICAL_OR_OP", "MUL_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "ADD_ASSIGN",
			"SUB_ASSIGN", "LEFT_ASSIGN", "RIGHT_ASSIGN", "AND_ASSIGN", "XOR_ASSIGN",
			"OR_ASSIGN", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMICOLON", "LBRACKET",
			"RBRACKET", "COMMA", "DOT", "PLUS_OP", "MINUS_OP", "LOGICAL_NOT_OP",
			"BITWISE_NEG_OP", "TIMES_OP", "DIV_OP", "MOD_OP", "LT_OP", "GT_OP", "BITWISE_AND_OP",
			"BITWISE_OR_OP", "BITWISE_XOR_OP", "QUERY_OP", "ASSIGN_OP", "PP_ENTER_MODE",
			"PP_EMPTY", "NR_LINE", "NR", "IDENTIFIER", "LINE_CONTINUE", "LINE_COMMENT",
			"BLOCK_COMMENT", "WS", "EOL", "NR_EXTENSION", "NR_VERSION", "NR_CUSTOM",
			"NR_INCLUDE", "NR_PRAGMA", "NR_PRAGMA_DEBUG", "NR_PRAGMA_OPTIMIZE", "NR_PRAGMA_INVARIANT",
			"NR_ON", "NR_OFF", "NR_ALL", "NR_REQUIRE", "NR_ENABLE", "NR_WARN", "NR_DISABLE",
			"NR_COLON", "NR_LPAREN", "NR_RPAREN", "NR_STDGL", "NR_CORE", "NR_COMPATIBILITY",
			"NR_ES", "NR_GLSL_110", "NR_GLSL_120", "NR_GLSLES_100", "NR_GLSL_130",
			"NR_GLSL_140", "NR_GLSL_150", "NR_GLSL_330", "NR_GLSLES_300", "NR_GLSLES_310",
			"NR_GLSLES_320", "NR_GLSL_400", "NR_GLSL_410", "NR_GLSL_420", "NR_GLSL_430",
			"NR_GLSL_440", "NR_GLSL_450", "NR_GLSL_460", "NR_STRING_START", "NR_STRING_START_ANGLE",
			"NR_INTCONSTANT", "NR_IDENTIFIER", "NR_LINE_CONTINUE", "NR_LINE_COMMENT",
			"NR_BLOCK_COMMENT", "NR_EOL", "NR_WS", "S_CONTENT", "S_STRING_END", "S_CONTENT_ANGLE",
			"S_STRING_END_ANGLE", "C_LINE_COMMENT", "C_BLOCK_COMMENT", "C_EOL", "C_WS",
			"C_CONTENT", "PP_LINE_CONTINUE", "PP_LINE_COMMENT", "PP_BLOCK_COMMENT",
			"PP_EOL", "PP_CONTENT"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GLSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TranslationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GLSLParser.EOF, 0); }
		public VersionStatementContext versionStatement() {
			return getRuleContext(VersionStatementContext.class,0);
		}
		public List<ExternalDeclarationContext> externalDeclaration() {
			return getRuleContexts(ExternalDeclarationContext.class);
		}
		public ExternalDeclarationContext externalDeclaration(int i) {
			return getRuleContext(ExternalDeclarationContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitTranslationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitTranslationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(104);
				versionStatement();
				}
				break;
			}
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 63771670216700L) != 0 || (((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -1L) != 0 || (((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & -1L) != 0 || (((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & 211106237775871L) != 0 || _la==NR || _la==IDENTIFIER) {
				{
				{
				setState(107);
				externalDeclaration();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VersionStatementContext extends ParserRuleContext {
		public Token version;
		public Token profile;
		public TerminalNode NR() { return getToken(GLSLParser.NR, 0); }
		public TerminalNode NR_VERSION() { return getToken(GLSLParser.NR_VERSION, 0); }
		public TerminalNode NR_EOL() { return getToken(GLSLParser.NR_EOL, 0); }
		public TerminalNode NR_GLSL_110() { return getToken(GLSLParser.NR_GLSL_110, 0); }
		public TerminalNode NR_GLSL_120() { return getToken(GLSLParser.NR_GLSL_120, 0); }
		public TerminalNode NR_GLSLES_100() { return getToken(GLSLParser.NR_GLSLES_100, 0); }
		public TerminalNode NR_GLSL_130() { return getToken(GLSLParser.NR_GLSL_130, 0); }
		public TerminalNode NR_GLSL_140() { return getToken(GLSLParser.NR_GLSL_140, 0); }
		public TerminalNode NR_GLSL_150() { return getToken(GLSLParser.NR_GLSL_150, 0); }
		public TerminalNode NR_GLSL_330() { return getToken(GLSLParser.NR_GLSL_330, 0); }
		public TerminalNode NR_GLSLES_300() { return getToken(GLSLParser.NR_GLSLES_300, 0); }
		public TerminalNode NR_GLSLES_310() { return getToken(GLSLParser.NR_GLSLES_310, 0); }
		public TerminalNode NR_GLSLES_320() { return getToken(GLSLParser.NR_GLSLES_320, 0); }
		public TerminalNode NR_GLSL_400() { return getToken(GLSLParser.NR_GLSL_400, 0); }
		public TerminalNode NR_GLSL_410() { return getToken(GLSLParser.NR_GLSL_410, 0); }
		public TerminalNode NR_GLSL_420() { return getToken(GLSLParser.NR_GLSL_420, 0); }
		public TerminalNode NR_GLSL_430() { return getToken(GLSLParser.NR_GLSL_430, 0); }
		public TerminalNode NR_GLSL_440() { return getToken(GLSLParser.NR_GLSL_440, 0); }
		public TerminalNode NR_GLSL_450() { return getToken(GLSLParser.NR_GLSL_450, 0); }
		public TerminalNode NR_GLSL_460() { return getToken(GLSLParser.NR_GLSL_460, 0); }
		public TerminalNode NR_CORE() { return getToken(GLSLParser.NR_CORE, 0); }
		public TerminalNode NR_COMPATIBILITY() { return getToken(GLSLParser.NR_COMPATIBILITY, 0); }
		public TerminalNode NR_ES() { return getToken(GLSLParser.NR_ES, 0); }
		public VersionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_versionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterVersionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitVersionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitVersionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VersionStatementContext versionStatement() throws RecognitionException {
		VersionStatementContext _localctx = new VersionStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_versionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(NR);
			setState(116);
			match(NR_VERSION);
			setState(117);
			((VersionStatementContext)_localctx).version = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la - 294)) & ~0x3f) == 0 && ((1L << (_la - 294)) & 131071L) != 0) ) {
				((VersionStatementContext)_localctx).version = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la - 291)) & ~0x3f) == 0 && ((1L << (_la - 291)) & 7L) != 0) {
				{
				setState(118);
				((VersionStatementContext)_localctx).profile = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la - 291)) & ~0x3f) == 0 && ((1L << (_la - 291)) & 7L) != 0) ) {
					((VersionStatementContext)_localctx).profile = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(121);
			match(NR_EOL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExternalDeclarationContext extends ParserRuleContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public PragmaDirectiveContext pragmaDirective() {
			return getRuleContext(PragmaDirectiveContext.class,0);
		}
		public ExtensionDirectiveContext extensionDirective() {
			return getRuleContext(ExtensionDirectiveContext.class,0);
		}
		public CustomDirectiveContext customDirective() {
			return getRuleContext(CustomDirectiveContext.class,0);
		}
		public IncludeDirectiveContext includeDirective() {
			return getRuleContext(IncludeDirectiveContext.class,0);
		}
		public LayoutDefaultsContext layoutDefaults() {
			return getRuleContext(LayoutDefaultsContext.class,0);
		}
		public EmptyDeclarationContext emptyDeclaration() {
			return getRuleContext(EmptyDeclarationContext.class,0);
		}
		public ExternalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterExternalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitExternalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitExternalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalDeclarationContext externalDeclaration() throws RecognitionException {
		ExternalDeclarationContext _localctx = new ExternalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_externalDeclaration);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				functionDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				pragmaDirective();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				extensionDirective();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				customDirective();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				includeDirective();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(129);
				layoutDefaults();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(130);
				emptyDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyDeclarationContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public EmptyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterEmptyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitEmptyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitEmptyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyDeclarationContext emptyDeclaration() throws RecognitionException {
		EmptyDeclarationContext _localctx = new EmptyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_emptyDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PragmaDirectiveContext extends ParserRuleContext {
		public Token stdGL;
		public Token type;
		public Token state;
		public TerminalNode NR() { return getToken(GLSLParser.NR, 0); }
		public TerminalNode NR_PRAGMA() { return getToken(GLSLParser.NR_PRAGMA, 0); }
		public TerminalNode NR_EOL() { return getToken(GLSLParser.NR_EOL, 0); }
		public TerminalNode NR_LPAREN() { return getToken(GLSLParser.NR_LPAREN, 0); }
		public TerminalNode NR_RPAREN() { return getToken(GLSLParser.NR_RPAREN, 0); }
		public TerminalNode NR_IDENTIFIER() { return getToken(GLSLParser.NR_IDENTIFIER, 0); }
		public TerminalNode NR_PRAGMA_INVARIANT() { return getToken(GLSLParser.NR_PRAGMA_INVARIANT, 0); }
		public TerminalNode NR_ALL() { return getToken(GLSLParser.NR_ALL, 0); }
		public TerminalNode NR_STDGL() { return getToken(GLSLParser.NR_STDGL, 0); }
		public TerminalNode NR_PRAGMA_DEBUG() { return getToken(GLSLParser.NR_PRAGMA_DEBUG, 0); }
		public TerminalNode NR_PRAGMA_OPTIMIZE() { return getToken(GLSLParser.NR_PRAGMA_OPTIMIZE, 0); }
		public TerminalNode NR_ON() { return getToken(GLSLParser.NR_ON, 0); }
		public TerminalNode NR_OFF() { return getToken(GLSLParser.NR_OFF, 0); }
		public PragmaDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragmaDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPragmaDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPragmaDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitPragmaDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PragmaDirectiveContext pragmaDirective() throws RecognitionException {
		PragmaDirectiveContext _localctx = new PragmaDirectiveContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pragmaDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(NR);
			setState(136);
			match(NR_PRAGMA);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NR_STDGL) {
				{
				setState(137);
				((PragmaDirectiveContext)_localctx).stdGL = match(NR_STDGL);
				}
			}

			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NR_IDENTIFIER:
				{
				setState(140);
				((PragmaDirectiveContext)_localctx).type = match(NR_IDENTIFIER);
				}
				break;
			case NR_PRAGMA_DEBUG:
			case NR_PRAGMA_OPTIMIZE:
				{
				setState(141);
				((PragmaDirectiveContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NR_PRAGMA_DEBUG || _la==NR_PRAGMA_OPTIMIZE) ) {
					((PragmaDirectiveContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(142);
				match(NR_LPAREN);
				setState(143);
				((PragmaDirectiveContext)_localctx).state = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NR_ON || _la==NR_OFF) ) {
					((PragmaDirectiveContext)_localctx).state = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(144);
				match(NR_RPAREN);
				}
				break;
			case NR_PRAGMA_INVARIANT:
				{
				setState(145);
				((PragmaDirectiveContext)_localctx).type = match(NR_PRAGMA_INVARIANT);
				setState(146);
				match(NR_LPAREN);
				setState(147);
				((PragmaDirectiveContext)_localctx).state = match(NR_ALL);
				setState(148);
				match(NR_RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(151);
			match(NR_EOL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExtensionDirectiveContext extends ParserRuleContext {
		public Token extensionName;
		public Token extensionBehavior;
		public TerminalNode NR() { return getToken(GLSLParser.NR, 0); }
		public TerminalNode NR_EXTENSION() { return getToken(GLSLParser.NR_EXTENSION, 0); }
		public TerminalNode NR_EOL() { return getToken(GLSLParser.NR_EOL, 0); }
		public TerminalNode NR_IDENTIFIER() { return getToken(GLSLParser.NR_IDENTIFIER, 0); }
		public TerminalNode NR_COLON() { return getToken(GLSLParser.NR_COLON, 0); }
		public TerminalNode NR_REQUIRE() { return getToken(GLSLParser.NR_REQUIRE, 0); }
		public TerminalNode NR_ENABLE() { return getToken(GLSLParser.NR_ENABLE, 0); }
		public TerminalNode NR_WARN() { return getToken(GLSLParser.NR_WARN, 0); }
		public TerminalNode NR_DISABLE() { return getToken(GLSLParser.NR_DISABLE, 0); }
		public ExtensionDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extensionDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterExtensionDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitExtensionDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitExtensionDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtensionDirectiveContext extensionDirective() throws RecognitionException {
		ExtensionDirectiveContext _localctx = new ExtensionDirectiveContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_extensionDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(NR);
			setState(154);
			match(NR_EXTENSION);
			setState(155);
			((ExtensionDirectiveContext)_localctx).extensionName = match(NR_IDENTIFIER);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NR_COLON) {
				{
				setState(156);
				match(NR_COLON);
				setState(157);
				((ExtensionDirectiveContext)_localctx).extensionBehavior = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la - 283)) & ~0x3f) == 0 && ((1L << (_la - 283)) & 15L) != 0) ) {
					((ExtensionDirectiveContext)_localctx).extensionBehavior = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(160);
			match(NR_EOL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CustomDirectiveContext extends ParserRuleContext {
		public Token content;
		public TerminalNode NR() { return getToken(GLSLParser.NR, 0); }
		public TerminalNode NR_CUSTOM() { return getToken(GLSLParser.NR_CUSTOM, 0); }
		public TerminalNode C_EOL() { return getToken(GLSLParser.C_EOL, 0); }
		public TerminalNode C_CONTENT() { return getToken(GLSLParser.C_CONTENT, 0); }
		public CustomDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterCustomDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitCustomDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitCustomDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CustomDirectiveContext customDirective() throws RecognitionException {
		CustomDirectiveContext _localctx = new CustomDirectiveContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_customDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(NR);
			setState(163);
			match(NR_CUSTOM);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==C_CONTENT) {
				{
				setState(164);
				((CustomDirectiveContext)_localctx).content = match(C_CONTENT);
				}
			}

			setState(167);
			match(C_EOL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IncludeDirectiveContext extends ParserRuleContext {
		public Token content;
		public Token angleStart;
		public TerminalNode NR() { return getToken(GLSLParser.NR, 0); }
		public TerminalNode NR_INCLUDE() { return getToken(GLSLParser.NR_INCLUDE, 0); }
		public TerminalNode NR_EOL() { return getToken(GLSLParser.NR_EOL, 0); }
		public TerminalNode NR_STRING_START() { return getToken(GLSLParser.NR_STRING_START, 0); }
		public TerminalNode S_STRING_END() { return getToken(GLSLParser.S_STRING_END, 0); }
		public TerminalNode S_STRING_END_ANGLE() { return getToken(GLSLParser.S_STRING_END_ANGLE, 0); }
		public TerminalNode NR_STRING_START_ANGLE() { return getToken(GLSLParser.NR_STRING_START_ANGLE, 0); }
		public TerminalNode S_CONTENT() { return getToken(GLSLParser.S_CONTENT, 0); }
		public TerminalNode S_CONTENT_ANGLE() { return getToken(GLSLParser.S_CONTENT_ANGLE, 0); }
		public IncludeDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterIncludeDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitIncludeDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitIncludeDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeDirectiveContext includeDirective() throws RecognitionException {
		IncludeDirectiveContext _localctx = new IncludeDirectiveContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_includeDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(NR);
			setState(170);
			match(NR_INCLUDE);
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NR_STRING_START:
				{
				setState(171);
				match(NR_STRING_START);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==S_CONTENT) {
					{
					setState(172);
					((IncludeDirectiveContext)_localctx).content = match(S_CONTENT);
					}
				}

				setState(175);
				match(S_STRING_END);
				}
				break;
			case NR_STRING_START_ANGLE:
				{
				setState(176);
				((IncludeDirectiveContext)_localctx).angleStart = match(NR_STRING_START_ANGLE);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==S_CONTENT_ANGLE) {
					{
					setState(177);
					((IncludeDirectiveContext)_localctx).content = match(S_CONTENT_ANGLE);
					}
				}

				setState(180);
				match(S_STRING_END_ANGLE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(183);
			match(NR_EOL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LayoutDefaultsContext extends ParserRuleContext {
		public Token layoutMode;
		public LayoutQualifierContext layoutQualifier() {
			return getRuleContext(LayoutQualifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public TerminalNode UNIFORM() { return getToken(GLSLParser.UNIFORM, 0); }
		public TerminalNode IN() { return getToken(GLSLParser.IN, 0); }
		public TerminalNode OUT() { return getToken(GLSLParser.OUT, 0); }
		public TerminalNode BUFFER() { return getToken(GLSLParser.BUFFER, 0); }
		public LayoutDefaultsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutDefaults; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLayoutDefaults(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLayoutDefaults(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitLayoutDefaults(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutDefaultsContext layoutDefaults() throws RecognitionException {
		LayoutDefaultsContext _localctx = new LayoutDefaultsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_layoutDefaults);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			layoutQualifier();
			setState(186);
			((LayoutDefaultsContext)_localctx).layoutMode = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 60L) != 0) ) {
				((LayoutDefaultsContext)_localctx).layoutMode = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(187);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionPrototypeContext functionPrototype() {
			return getRuleContext(FunctionPrototypeContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			functionPrototype();
			setState(190);
			compoundStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FiniteExpressionContext extends ParserRuleContext {
		public FiniteExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finiteExpression; }

		public FiniteExpressionContext() { }
		public void copyFrom(FiniteExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ShiftExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode LEFT_OP() { return getToken(GLSLParser.LEFT_OP, 0); }
		public TerminalNode RIGHT_OP() { return getToken(GLSLParser.RIGHT_OP, 0); }
		public ShiftExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceExpressionContext extends FiniteExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public ReferenceExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterReferenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitReferenceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitReferenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode PLUS_OP() { return getToken(GLSLParser.PLUS_OP, 0); }
		public TerminalNode MINUS_OP() { return getToken(GLSLParser.MINUS_OP, 0); }
		public AdditiveExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode LT_OP() { return getToken(GLSLParser.LT_OP, 0); }
		public TerminalNode GT_OP() { return getToken(GLSLParser.GT_OP, 0); }
		public TerminalNode LE_OP() { return getToken(GLSLParser.LE_OP, 0); }
		public TerminalNode GE_OP() { return getToken(GLSLParser.GE_OP, 0); }
		public RelationalExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExclusiveOrExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode LOGICAL_XOR_OP() { return getToken(GLSLParser.LOGICAL_XOR_OP, 0); }
		public LogicalExclusiveOrExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLogicalExclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLogicalExclusiveOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitLogicalExclusiveOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext condition;
		public FiniteExpressionContext trueAlternative;
		public FiniteExpressionContext falseAlternative;
		public TerminalNode QUERY_OP() { return getToken(GLSLParser.QUERY_OP, 0); }
		public TerminalNode COLON() { return getToken(GLSLParser.COLON, 0); }
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public ConditionalExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode ASSIGN_OP() { return getToken(GLSLParser.ASSIGN_OP, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(GLSLParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(GLSLParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(GLSLParser.MOD_ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(GLSLParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(GLSLParser.SUB_ASSIGN, 0); }
		public TerminalNode LEFT_ASSIGN() { return getToken(GLSLParser.LEFT_ASSIGN, 0); }
		public TerminalNode RIGHT_ASSIGN() { return getToken(GLSLParser.RIGHT_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(GLSLParser.AND_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(GLSLParser.XOR_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(GLSLParser.OR_ASSIGN, 0); }
		public AssignmentExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LengthAccessExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext operand;
		public TerminalNode DOT_LENGTH_METHOD_CALL() { return getToken(GLSLParser.DOT_LENGTH_METHOD_CALL, 0); }
		public FiniteExpressionContext finiteExpression() {
			return getRuleContext(FiniteExpressionContext.class,0);
		}
		public LengthAccessExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLengthAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLengthAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitLengthAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode TIMES_OP() { return getToken(GLSLParser.TIMES_OP, 0); }
		public TerminalNode DIV_OP() { return getToken(GLSLParser.DIV_OP, 0); }
		public TerminalNode MOD_OP() { return getToken(GLSLParser.MOD_OP, 0); }
		public MultiplicativeExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupingExpressionContext extends FiniteExpressionContext {
		public ExpressionContext value;
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GroupingExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterGroupingExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitGroupingExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitGroupingExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public ExpressionContext right;
		public TerminalNode LBRACKET() { return getToken(GLSLParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(GLSLParser.RBRACKET, 0); }
		public FiniteExpressionContext finiteExpression() {
			return getRuleContext(FiniteExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayAccessExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterArrayAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitArrayAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitArrayAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrefixExpressionContext extends FiniteExpressionContext {
		public Token op;
		public FiniteExpressionContext operand;
		public FiniteExpressionContext finiteExpression() {
			return getRuleContext(FiniteExpressionContext.class,0);
		}
		public TerminalNode INC_OP() { return getToken(GLSLParser.INC_OP, 0); }
		public TerminalNode DEC_OP() { return getToken(GLSLParser.DEC_OP, 0); }
		public TerminalNode PLUS_OP() { return getToken(GLSLParser.PLUS_OP, 0); }
		public TerminalNode MINUS_OP() { return getToken(GLSLParser.MINUS_OP, 0); }
		public TerminalNode LOGICAL_NOT_OP() { return getToken(GLSLParser.LOGICAL_NOT_OP, 0); }
		public TerminalNode BITWISE_NEG_OP() { return getToken(GLSLParser.BITWISE_NEG_OP, 0); }
		public PrefixExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPrefixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPrefixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitPrefixExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseInclusiveOrExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode BITWISE_OR_OP() { return getToken(GLSLParser.BITWISE_OR_OP, 0); }
		public BitwiseInclusiveOrExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterBitwiseInclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitBitwiseInclusiveOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitBitwiseInclusiveOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalInclusiveOrExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode LOGICAL_OR_OP() { return getToken(GLSLParser.LOGICAL_OR_OP, 0); }
		public LogicalInclusiveOrExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLogicalInclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLogicalInclusiveOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitLogicalInclusiveOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseAndExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode BITWISE_AND_OP() { return getToken(GLSLParser.BITWISE_AND_OP, 0); }
		public BitwiseAndExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterBitwiseAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitBitwiseAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitBitwiseAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode EQ_OP() { return getToken(GLSLParser.EQ_OP, 0); }
		public TerminalNode NE_OP() { return getToken(GLSLParser.NE_OP, 0); }
		public EqualityExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode LOGICAL_AND_OP() { return getToken(GLSLParser.LOGICAL_AND_OP, 0); }
		public LogicalAndExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLogicalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLogicalAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitLogicalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext finiteExpression;
		public List<FiniteExpressionContext> parameters = new ArrayList<FiniteExpressionContext>();
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode VOID() { return getToken(GLSLParser.VOID, 0); }
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public FunctionCallExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunctionCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseExclusiveOrExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext left;
		public Token op;
		public FiniteExpressionContext right;
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public TerminalNode BITWISE_XOR_OP() { return getToken(GLSLParser.BITWISE_XOR_OP, 0); }
		public BitwiseExclusiveOrExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterBitwiseExclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitBitwiseExclusiveOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitBitwiseExclusiveOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext operand;
		public Token member;
		public TerminalNode DOT() { return getToken(GLSLParser.DOT, 0); }
		public FiniteExpressionContext finiteExpression() {
			return getRuleContext(FiniteExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public MemberAccessExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterMemberAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitMemberAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitMemberAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExpressionContext extends FiniteExpressionContext {
		public TerminalNode INT16CONSTANT() { return getToken(GLSLParser.INT16CONSTANT, 0); }
		public TerminalNode UINT16CONSTANT() { return getToken(GLSLParser.UINT16CONSTANT, 0); }
		public TerminalNode INT32CONSTANT() { return getToken(GLSLParser.INT32CONSTANT, 0); }
		public TerminalNode UINT32CONSTANT() { return getToken(GLSLParser.UINT32CONSTANT, 0); }
		public TerminalNode INT64CONSTANT() { return getToken(GLSLParser.INT64CONSTANT, 0); }
		public TerminalNode UINT64CONSTANT() { return getToken(GLSLParser.UINT64CONSTANT, 0); }
		public TerminalNode FLOAT16CONSTANT() { return getToken(GLSLParser.FLOAT16CONSTANT, 0); }
		public TerminalNode FLOAT32CONSTANT() { return getToken(GLSLParser.FLOAT32CONSTANT, 0); }
		public TerminalNode FLOAT64CONSTANT() { return getToken(GLSLParser.FLOAT64CONSTANT, 0); }
		public TerminalNode BOOLCONSTANT() { return getToken(GLSLParser.BOOLCONSTANT, 0); }
		public LiteralExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExpressionContext extends FiniteExpressionContext {
		public FiniteExpressionContext operand;
		public Token op;
		public FiniteExpressionContext finiteExpression() {
			return getRuleContext(FiniteExpressionContext.class,0);
		}
		public TerminalNode INC_OP() { return getToken(GLSLParser.INC_OP, 0); }
		public TerminalNode DEC_OP() { return getToken(GLSLParser.DEC_OP, 0); }
		public PostfixExpressionContext(FiniteExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPostfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FiniteExpressionContext finiteExpression() throws RecognitionException {
		return finiteExpression(0);
	}

	private FiniteExpressionContext finiteExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FiniteExpressionContext _localctx = new FiniteExpressionContext(_ctx, _parentState);
		FiniteExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_finiteExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new ReferenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(193);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				_localctx = new LiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				_la = _input.LA(1);
				if ( !((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & 1023L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				{
				_localctx = new GroupingExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(LPAREN);
				setState(196);
				((GroupingExpressionContext)_localctx).value = expression();
				setState(197);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(199);
					match(IDENTIFIER);
					}
					break;
				case 2:
					{
					setState(200);
					typeSpecifier();
					}
					break;
				}
				setState(203);
				match(LPAREN);
				setState(214);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					}
					break;
				case 2:
					{
					setState(205);
					match(VOID);
					}
					break;
				case 3:
					{
					setState(206);
					((FunctionCallExpressionContext)_localctx).finiteExpression = finiteExpression(0);
					((FunctionCallExpressionContext)_localctx).parameters.add(((FunctionCallExpressionContext)_localctx).finiteExpression);
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(207);
						match(COMMA);
						setState(208);
						((FunctionCallExpressionContext)_localctx).finiteExpression = finiteExpression(0);
						((FunctionCallExpressionContext)_localctx).parameters.add(((FunctionCallExpressionContext)_localctx).finiteExpression);
						}
						}
						setState(213);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(216);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new PrefixExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				((PrefixExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la - 217)) & ~0x3f) == 0 && ((1L << (_la - 217)) & 32212254723L) != 0) ) {
					((PrefixExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(218);
				((PrefixExpressionContext)_localctx).operand = finiteExpression(14);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(277);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=repack.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(275);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((MultiplicativeExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(221);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(222);
						((MultiplicativeExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la - 252)) & ~0x3f) == 0 && ((1L << (_la - 252)) & 7L) != 0) ) {
							((MultiplicativeExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(223);
						((MultiplicativeExpressionContext)_localctx).right = finiteExpression(14);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((AdditiveExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(224);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(225);
						((AdditiveExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS_OP || _la==MINUS_OP) ) {
							((AdditiveExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(226);
						((AdditiveExpressionContext)_localctx).right = finiteExpression(13);
						}
						break;
					case 3:
						{
						_localctx = new ShiftExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((ShiftExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(227);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(228);
						((ShiftExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LEFT_OP || _la==RIGHT_OP) ) {
							((ShiftExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(229);
						((ShiftExpressionContext)_localctx).right = finiteExpression(12);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((RelationalExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(230);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(231);
						((RelationalExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la - 222)) & ~0x3f) == 0 && ((1L << (_la - 222)) & 25769803779L) != 0) ) {
							((RelationalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(232);
						((RelationalExpressionContext)_localctx).right = finiteExpression(11);
						}
						break;
					case 5:
						{
						_localctx = new EqualityExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((EqualityExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(233);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(234);
						((EqualityExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ_OP || _la==NE_OP) ) {
							((EqualityExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(235);
						((EqualityExpressionContext)_localctx).right = finiteExpression(10);
						}
						break;
					case 6:
						{
						_localctx = new BitwiseAndExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((BitwiseAndExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(236);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(237);
						((BitwiseAndExpressionContext)_localctx).op = match(BITWISE_AND_OP);
						setState(238);
						((BitwiseAndExpressionContext)_localctx).right = finiteExpression(9);
						}
						break;
					case 7:
						{
						_localctx = new BitwiseExclusiveOrExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((BitwiseExclusiveOrExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(239);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(240);
						((BitwiseExclusiveOrExpressionContext)_localctx).op = match(BITWISE_XOR_OP);
						setState(241);
						((BitwiseExclusiveOrExpressionContext)_localctx).right = finiteExpression(8);
						}
						break;
					case 8:
						{
						_localctx = new BitwiseInclusiveOrExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((BitwiseInclusiveOrExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(242);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(243);
						((BitwiseInclusiveOrExpressionContext)_localctx).op = match(BITWISE_OR_OP);
						setState(244);
						((BitwiseInclusiveOrExpressionContext)_localctx).right = finiteExpression(7);
						}
						break;
					case 9:
						{
						_localctx = new LogicalAndExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((LogicalAndExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(245);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(246);
						((LogicalAndExpressionContext)_localctx).op = match(LOGICAL_AND_OP);
						setState(247);
						((LogicalAndExpressionContext)_localctx).right = finiteExpression(6);
						}
						break;
					case 10:
						{
						_localctx = new LogicalExclusiveOrExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((LogicalExclusiveOrExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(248);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(249);
						((LogicalExclusiveOrExpressionContext)_localctx).op = match(LOGICAL_XOR_OP);
						setState(250);
						((LogicalExclusiveOrExpressionContext)_localctx).right = finiteExpression(5);
						}
						break;
					case 11:
						{
						_localctx = new LogicalInclusiveOrExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((LogicalInclusiveOrExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(251);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(252);
						((LogicalInclusiveOrExpressionContext)_localctx).op = match(LOGICAL_OR_OP);
						setState(253);
						((LogicalInclusiveOrExpressionContext)_localctx).right = finiteExpression(4);
						}
						break;
					case 12:
						{
						_localctx = new ConditionalExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((ConditionalExpressionContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(254);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(255);
						match(QUERY_OP);
						setState(256);
						((ConditionalExpressionContext)_localctx).trueAlternative = finiteExpression(0);
						setState(257);
						match(COLON);
						setState(258);
						((ConditionalExpressionContext)_localctx).falseAlternative = finiteExpression(2);
						}
						break;
					case 13:
						{
						_localctx = new AssignmentExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((AssignmentExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(260);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(261);
						((AssignmentExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la - 229)) & ~0x3f) == 0 && ((1L << (_la - 229)) & 4294968319L) != 0) ) {
							((AssignmentExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(262);
						((AssignmentExpressionContext)_localctx).right = finiteExpression(1);
						}
						break;
					case 14:
						{
						_localctx = new ArrayAccessExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((ArrayAccessExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(263);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(264);
						match(LBRACKET);
						setState(265);
						((ArrayAccessExpressionContext)_localctx).right = expression();
						setState(266);
						match(RBRACKET);
						}
						break;
					case 15:
						{
						_localctx = new LengthAccessExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((LengthAccessExpressionContext)_localctx).operand = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(268);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(269);
						match(DOT_LENGTH_METHOD_CALL);
						}
						break;
					case 16:
						{
						_localctx = new MemberAccessExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((MemberAccessExpressionContext)_localctx).operand = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(270);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(271);
						match(DOT);
						setState(272);
						((MemberAccessExpressionContext)_localctx).member = match(IDENTIFIER);
						}
						break;
					case 17:
						{
						_localctx = new PostfixExpressionContext(new FiniteExpressionContext(_parentctx, _parentState));
						((PostfixExpressionContext)_localctx).operand = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_finiteExpression);
						setState(273);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(274);
						((PostfixExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC_OP || _la==DEC_OP) ) {
							((PostfixExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					}
				}
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public FiniteExpressionContext finiteExpression;
		public List<FiniteExpressionContext> items = new ArrayList<FiniteExpressionContext>();
		public List<FiniteExpressionContext> finiteExpression() {
			return getRuleContexts(FiniteExpressionContext.class);
		}
		public FiniteExpressionContext finiteExpression(int i) {
			return getRuleContext(FiniteExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			((ExpressionContext)_localctx).finiteExpression = finiteExpression(0);
			((ExpressionContext)_localctx).items.add(((ExpressionContext)_localctx).finiteExpression);
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=repack.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(281);
					match(COMMA);
					setState(282);
					((ExpressionContext)_localctx).finiteExpression = finiteExpression(0);
					((ExpressionContext)_localctx).items.add(((ExpressionContext)_localctx).finiteExpression);
					}
					}
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }

		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrecisionDeclarationContext extends DeclarationContext {
		public TerminalNode PRECISION() { return getToken(GLSLParser.PRECISION, 0); }
		public PrecisionQualifierContext precisionQualifier() {
			return getRuleContext(PrecisionQualifierContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public PrecisionDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPrecisionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPrecisionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitPrecisionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeAndInitDeclarationContext extends DeclarationContext {
		public DeclarationMemberContext declarationMember;
		public List<DeclarationMemberContext> declarationMembers = new ArrayList<DeclarationMemberContext>();
		public FullySpecifiedTypeContext fullySpecifiedType() {
			return getRuleContext(FullySpecifiedTypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public List<DeclarationMemberContext> declarationMember() {
			return getRuleContexts(DeclarationMemberContext.class);
		}
		public DeclarationMemberContext declarationMember(int i) {
			return getRuleContext(DeclarationMemberContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public TypeAndInitDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterTypeAndInitDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitTypeAndInitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitTypeAndInitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceBlockDeclarationContext extends DeclarationContext {
		public Token blockName;
		public Token variableName;
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public StructBodyContext structBody() {
			return getRuleContext(StructBodyContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(GLSLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GLSLParser.IDENTIFIER, i);
		}
		public ArraySpecifierContext arraySpecifier() {
			return getRuleContext(ArraySpecifierContext.class,0);
		}
		public InterfaceBlockDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInterfaceBlockDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInterfaceBlockDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitInterfaceBlockDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends DeclarationContext {
		public FunctionPrototypeContext functionPrototype() {
			return getRuleContext(FunctionPrototypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public FunctionDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends DeclarationContext {
		public Token IDENTIFIER;
		public List<Token> variableNames = new ArrayList<Token>();
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(GLSLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GLSLParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public VariableDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaration);
		int _la;
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new FunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				functionPrototype();
				setState(289);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new InterfaceBlockDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				typeQualifier();
				setState(292);
				((InterfaceBlockDeclarationContext)_localctx).blockName = match(IDENTIFIER);
				setState(293);
				structBody();
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(294);
					((InterfaceBlockDeclarationContext)_localctx).variableName = match(IDENTIFIER);
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LBRACKET) {
						{
						setState(295);
						arraySpecifier();
						}
					}

					}
				}

				setState(300);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new VariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(302);
				typeQualifier();
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(303);
					((VariableDeclarationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					((VariableDeclarationContext)_localctx).variableNames.add(((VariableDeclarationContext)_localctx).IDENTIFIER);
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(304);
						match(COMMA);
						setState(305);
						((VariableDeclarationContext)_localctx).IDENTIFIER = match(IDENTIFIER);
						((VariableDeclarationContext)_localctx).variableNames.add(((VariableDeclarationContext)_localctx).IDENTIFIER);
						}
						}
						setState(310);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(313);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new PrecisionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(315);
				match(PRECISION);
				setState(316);
				precisionQualifier();
				setState(317);
				typeSpecifier();
				setState(318);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new TypeAndInitDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(320);
				fullySpecifiedType();
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(321);
					((TypeAndInitDeclarationContext)_localctx).declarationMember = declarationMember();
					((TypeAndInitDeclarationContext)_localctx).declarationMembers.add(((TypeAndInitDeclarationContext)_localctx).declarationMember);
					setState(326);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(322);
						match(COMMA);
						setState(323);
						((TypeAndInitDeclarationContext)_localctx).declarationMember = declarationMember();
						((TypeAndInitDeclarationContext)_localctx).declarationMembers.add(((TypeAndInitDeclarationContext)_localctx).declarationMember);
						}
						}
						setState(328);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(331);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionPrototypeContext extends ParserRuleContext {
		public FullySpecifiedTypeContext fullySpecifiedType() {
			return getRuleContext(FullySpecifiedTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public FunctionParameterListContext functionParameterList() {
			return getRuleContext(FunctionParameterListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public FunctionPrototypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionPrototype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunctionPrototype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunctionPrototype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitFunctionPrototype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionPrototypeContext functionPrototype() throws RecognitionException {
		FunctionPrototypeContext _localctx = new FunctionPrototypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionPrototype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(335);
				attribute();
				}
			}

			setState(338);
			fullySpecifiedType();
			setState(339);
			match(IDENTIFIER);
			setState(340);
			match(LPAREN);
			setState(341);
			functionParameterList();
			setState(342);
			match(RPAREN);
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(343);
				attribute();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionParameterListContext extends ParserRuleContext {
		public ParameterDeclarationContext parameterDeclaration;
		public List<ParameterDeclarationContext> parameters = new ArrayList<ParameterDeclarationContext>();
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public FunctionParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunctionParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunctionParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitFunctionParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParameterListContext functionParameterList() throws RecognitionException {
		FunctionParameterListContext _localctx = new FunctionParameterListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 63771670215676L) != 0 || (((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -1L) != 0 || (((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & -1L) != 0 || (((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & 5242879L) != 0 || _la==IDENTIFIER) {
				{
				setState(346);
				((FunctionParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
				((FunctionParameterListContext)_localctx).parameters.add(((FunctionParameterListContext)_localctx).parameterDeclaration);
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(347);
					match(COMMA);
					setState(348);
					((FunctionParameterListContext)_localctx).parameterDeclaration = parameterDeclaration();
					((FunctionParameterListContext)_localctx).parameters.add(((FunctionParameterListContext)_localctx).parameterDeclaration);
					}
					}
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public Token parameterName;
		public FullySpecifiedTypeContext fullySpecifiedType() {
			return getRuleContext(FullySpecifiedTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public ArraySpecifierContext arraySpecifier() {
			return getRuleContext(ArraySpecifierContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			fullySpecifiedType();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(357);
				((ParameterDeclarationContext)_localctx).parameterName = match(IDENTIFIER);
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(358);
					arraySpecifier();
					}
				}

				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public SingleAttributeContext singleAttribute;
		public List<SingleAttributeContext> attributes = new ArrayList<SingleAttributeContext>();
		public List<TerminalNode> LBRACKET() { return getTokens(GLSLParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(GLSLParser.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(GLSLParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(GLSLParser.RBRACKET, i);
		}
		public List<SingleAttributeContext> singleAttribute() {
			return getRuleContexts(SingleAttributeContext.class);
		}
		public SingleAttributeContext singleAttribute(int i) {
			return getRuleContext(SingleAttributeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(LBRACKET);
			setState(364);
			match(LBRACKET);
			setState(365);
			((AttributeContext)_localctx).singleAttribute = singleAttribute();
			((AttributeContext)_localctx).attributes.add(((AttributeContext)_localctx).singleAttribute);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(366);
				match(COMMA);
				setState(367);
				((AttributeContext)_localctx).singleAttribute = singleAttribute();
				((AttributeContext)_localctx).attributes.add(((AttributeContext)_localctx).singleAttribute);
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(373);
			match(RBRACKET);
			setState(374);
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SingleAttributeContext extends ParserRuleContext {
		public Token prefix;
		public Token name;
		public ExpressionContext content;
		public List<TerminalNode> IDENTIFIER() { return getTokens(GLSLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GLSLParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COLON() { return getTokens(GLSLParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(GLSLParser.COLON, i);
		}
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SingleAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSingleAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSingleAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitSingleAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleAttributeContext singleAttribute() throws RecognitionException {
		SingleAttributeContext _localctx = new SingleAttributeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_singleAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(376);
				((SingleAttributeContext)_localctx).prefix = match(IDENTIFIER);
				setState(377);
				match(COLON);
				setState(378);
				match(COLON);
				}
				break;
			}
			setState(381);
			((SingleAttributeContext)_localctx).name = match(IDENTIFIER);
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(382);
				match(LPAREN);
				setState(383);
				((SingleAttributeContext)_localctx).content = expression();
				setState(384);
				match(RPAREN);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationMemberContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public ArraySpecifierContext arraySpecifier() {
			return getRuleContext(ArraySpecifierContext.class,0);
		}
		public TerminalNode ASSIGN_OP() { return getToken(GLSLParser.ASSIGN_OP, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public DeclarationMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterDeclarationMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitDeclarationMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitDeclarationMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationMemberContext declarationMember() throws RecognitionException {
		DeclarationMemberContext _localctx = new DeclarationMemberContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_declarationMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(IDENTIFIER);
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(389);
				arraySpecifier();
				}
			}

			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN_OP) {
				{
				setState(392);
				match(ASSIGN_OP);
				setState(393);
				initializer();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class FullySpecifiedTypeContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public FullySpecifiedTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullySpecifiedType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFullySpecifiedType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFullySpecifiedType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitFullySpecifiedType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullySpecifiedTypeContext fullySpecifiedType() throws RecognitionException {
		FullySpecifiedTypeContext _localctx = new FullySpecifiedTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fullySpecifiedType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 2199019060220L) != 0) {
				{
				setState(396);
				typeQualifier();
				}
			}

			setState(399);
			typeSpecifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StorageQualifierContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public List<Token> typeNames = new ArrayList<Token>();
		public TerminalNode CONST() { return getToken(GLSLParser.CONST, 0); }
		public TerminalNode IN() { return getToken(GLSLParser.IN, 0); }
		public TerminalNode OUT() { return getToken(GLSLParser.OUT, 0); }
		public TerminalNode INOUT() { return getToken(GLSLParser.INOUT, 0); }
		public TerminalNode CENTROID() { return getToken(GLSLParser.CENTROID, 0); }
		public TerminalNode PATCH() { return getToken(GLSLParser.PATCH, 0); }
		public TerminalNode SAMPLE() { return getToken(GLSLParser.SAMPLE, 0); }
		public TerminalNode UNIFORM() { return getToken(GLSLParser.UNIFORM, 0); }
		public TerminalNode VARYING() { return getToken(GLSLParser.VARYING, 0); }
		public TerminalNode ATTRIBUTE() { return getToken(GLSLParser.ATTRIBUTE, 0); }
		public TerminalNode BUFFER() { return getToken(GLSLParser.BUFFER, 0); }
		public TerminalNode SHARED() { return getToken(GLSLParser.SHARED, 0); }
		public TerminalNode RESTRICT() { return getToken(GLSLParser.RESTRICT, 0); }
		public TerminalNode VOLATILE() { return getToken(GLSLParser.VOLATILE, 0); }
		public TerminalNode COHERENT() { return getToken(GLSLParser.COHERENT, 0); }
		public TerminalNode READONLY() { return getToken(GLSLParser.READONLY, 0); }
		public TerminalNode WRITEONLY() { return getToken(GLSLParser.WRITEONLY, 0); }
		public TerminalNode SUBROUTINE() { return getToken(GLSLParser.SUBROUTINE, 0); }
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(GLSLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GLSLParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public TerminalNode DEVICECOHERENT() { return getToken(GLSLParser.DEVICECOHERENT, 0); }
		public TerminalNode QUEUEFAMILYCOHERENT() { return getToken(GLSLParser.QUEUEFAMILYCOHERENT, 0); }
		public TerminalNode WORKGROUPCOHERENT() { return getToken(GLSLParser.WORKGROUPCOHERENT, 0); }
		public TerminalNode SUBGROUPCOHERENT() { return getToken(GLSLParser.SUBGROUPCOHERENT, 0); }
		public TerminalNode NONPRIVATE() { return getToken(GLSLParser.NONPRIVATE, 0); }
		public TerminalNode RAY_PAYLOAD_EXT() { return getToken(GLSLParser.RAY_PAYLOAD_EXT, 0); }
		public TerminalNode RAY_PAYLOAD_IN_EXT() { return getToken(GLSLParser.RAY_PAYLOAD_IN_EXT, 0); }
		public TerminalNode HIT_ATTRIBUTE_EXT() { return getToken(GLSLParser.HIT_ATTRIBUTE_EXT, 0); }
		public TerminalNode CALLABLE_DATA_EXT() { return getToken(GLSLParser.CALLABLE_DATA_EXT, 0); }
		public TerminalNode CALLABLE_DATA_IN_EXT() { return getToken(GLSLParser.CALLABLE_DATA_IN_EXT, 0); }
		public StorageQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStorageQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStorageQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitStorageQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StorageQualifierContext storageQualifier() throws RecognitionException {
		StorageQualifierContext _localctx = new StorageQualifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_storageQualifier);
		int _la;
		try {
			setState(441);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				match(CONST);
				}
				break;
			case IN:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				match(IN);
				}
				break;
			case OUT:
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				match(OUT);
				}
				break;
			case INOUT:
				enterOuterAlt(_localctx, 4);
				{
				setState(404);
				match(INOUT);
				}
				break;
			case CENTROID:
				enterOuterAlt(_localctx, 5);
				{
				setState(405);
				match(CENTROID);
				}
				break;
			case PATCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(406);
				match(PATCH);
				}
				break;
			case SAMPLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(407);
				match(SAMPLE);
				}
				break;
			case UNIFORM:
				enterOuterAlt(_localctx, 8);
				{
				setState(408);
				match(UNIFORM);
				}
				break;
			case VARYING:
				enterOuterAlt(_localctx, 9);
				{
				setState(409);
				match(VARYING);
				}
				break;
			case ATTRIBUTE:
				enterOuterAlt(_localctx, 10);
				{
				setState(410);
				match(ATTRIBUTE);
				}
				break;
			case BUFFER:
				enterOuterAlt(_localctx, 11);
				{
				setState(411);
				match(BUFFER);
				}
				break;
			case SHARED:
				enterOuterAlt(_localctx, 12);
				{
				setState(412);
				match(SHARED);
				}
				break;
			case RESTRICT:
				enterOuterAlt(_localctx, 13);
				{
				setState(413);
				match(RESTRICT);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 14);
				{
				setState(414);
				match(VOLATILE);
				}
				break;
			case COHERENT:
				enterOuterAlt(_localctx, 15);
				{
				setState(415);
				match(COHERENT);
				}
				break;
			case READONLY:
				enterOuterAlt(_localctx, 16);
				{
				setState(416);
				match(READONLY);
				}
				break;
			case WRITEONLY:
				enterOuterAlt(_localctx, 17);
				{
				setState(417);
				match(WRITEONLY);
				}
				break;
			case SUBROUTINE:
				enterOuterAlt(_localctx, 18);
				{
				setState(418);
				match(SUBROUTINE);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(419);
					match(LPAREN);
					setState(420);
					((StorageQualifierContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					((StorageQualifierContext)_localctx).typeNames.add(((StorageQualifierContext)_localctx).IDENTIFIER);
					setState(425);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(421);
						match(COMMA);
						setState(422);
						((StorageQualifierContext)_localctx).IDENTIFIER = match(IDENTIFIER);
						((StorageQualifierContext)_localctx).typeNames.add(((StorageQualifierContext)_localctx).IDENTIFIER);
						}
						}
						setState(427);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(428);
					match(RPAREN);
					}
				}

				}
				break;
			case DEVICECOHERENT:
				enterOuterAlt(_localctx, 19);
				{
				setState(431);
				match(DEVICECOHERENT);
				}
				break;
			case QUEUEFAMILYCOHERENT:
				enterOuterAlt(_localctx, 20);
				{
				setState(432);
				match(QUEUEFAMILYCOHERENT);
				}
				break;
			case WORKGROUPCOHERENT:
				enterOuterAlt(_localctx, 21);
				{
				setState(433);
				match(WORKGROUPCOHERENT);
				}
				break;
			case SUBGROUPCOHERENT:
				enterOuterAlt(_localctx, 22);
				{
				setState(434);
				match(SUBGROUPCOHERENT);
				}
				break;
			case NONPRIVATE:
				enterOuterAlt(_localctx, 23);
				{
				setState(435);
				match(NONPRIVATE);
				}
				break;
			case RAY_PAYLOAD_EXT:
				enterOuterAlt(_localctx, 24);
				{
				setState(436);
				match(RAY_PAYLOAD_EXT);
				}
				break;
			case RAY_PAYLOAD_IN_EXT:
				enterOuterAlt(_localctx, 25);
				{
				setState(437);
				match(RAY_PAYLOAD_IN_EXT);
				}
				break;
			case HIT_ATTRIBUTE_EXT:
				enterOuterAlt(_localctx, 26);
				{
				setState(438);
				match(HIT_ATTRIBUTE_EXT);
				}
				break;
			case CALLABLE_DATA_EXT:
				enterOuterAlt(_localctx, 27);
				{
				setState(439);
				match(CALLABLE_DATA_EXT);
				}
				break;
			case CALLABLE_DATA_IN_EXT:
				enterOuterAlt(_localctx, 28);
				{
				setState(440);
				match(CALLABLE_DATA_IN_EXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LayoutQualifierContext extends ParserRuleContext {
		public LayoutQualifierIdContext layoutQualifierId;
		public List<LayoutQualifierIdContext> layoutQualifiers = new ArrayList<LayoutQualifierIdContext>();
		public TerminalNode LAYOUT() { return getToken(GLSLParser.LAYOUT, 0); }
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public List<LayoutQualifierIdContext> layoutQualifierId() {
			return getRuleContexts(LayoutQualifierIdContext.class);
		}
		public LayoutQualifierIdContext layoutQualifierId(int i) {
			return getRuleContext(LayoutQualifierIdContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public LayoutQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLayoutQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLayoutQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitLayoutQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutQualifierContext layoutQualifier() throws RecognitionException {
		LayoutQualifierContext _localctx = new LayoutQualifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_layoutQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(LAYOUT);
			setState(444);
			match(LPAREN);
			setState(445);
			((LayoutQualifierContext)_localctx).layoutQualifierId = layoutQualifierId();
			((LayoutQualifierContext)_localctx).layoutQualifiers.add(((LayoutQualifierContext)_localctx).layoutQualifierId);
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(446);
				match(COMMA);
				setState(447);
				((LayoutQualifierContext)_localctx).layoutQualifierId = layoutQualifierId();
				((LayoutQualifierContext)_localctx).layoutQualifiers.add(((LayoutQualifierContext)_localctx).layoutQualifierId);
				}
				}
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(453);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LayoutQualifierIdContext extends ParserRuleContext {
		public LayoutQualifierIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layoutQualifierId; }

		public LayoutQualifierIdContext() { }
		public void copyFrom(LayoutQualifierIdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SharedLayoutQualifierContext extends LayoutQualifierIdContext {
		public TerminalNode SHARED() { return getToken(GLSLParser.SHARED, 0); }
		public SharedLayoutQualifierContext(LayoutQualifierIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSharedLayoutQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSharedLayoutQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitSharedLayoutQualifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NamedLayoutQualifierContext extends LayoutQualifierIdContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(GLSLParser.ASSIGN_OP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NamedLayoutQualifierContext(LayoutQualifierIdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterNamedLayoutQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitNamedLayoutQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitNamedLayoutQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LayoutQualifierIdContext layoutQualifierId() throws RecognitionException {
		LayoutQualifierIdContext _localctx = new LayoutQualifierIdContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_layoutQualifierId);
		int _la;
		try {
			setState(461);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new NamedLayoutQualifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				match(IDENTIFIER);
				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN_OP) {
					{
					setState(456);
					match(ASSIGN_OP);
					setState(457);
					expression();
					}
				}

				}
				break;
			case SHARED:
				_localctx = new SharedLayoutQualifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(460);
				match(SHARED);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrecisionQualifierContext extends ParserRuleContext {
		public TerminalNode HIGHP() { return getToken(GLSLParser.HIGHP, 0); }
		public TerminalNode MEDIUMP() { return getToken(GLSLParser.MEDIUMP, 0); }
		public TerminalNode LOWP() { return getToken(GLSLParser.LOWP, 0); }
		public PrecisionQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precisionQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPrecisionQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPrecisionQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitPrecisionQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrecisionQualifierContext precisionQualifier() throws RecognitionException {
		PrecisionQualifierContext _localctx = new PrecisionQualifierContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_precisionQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterpolationQualifierContext extends ParserRuleContext {
		public TerminalNode SMOOTH() { return getToken(GLSLParser.SMOOTH, 0); }
		public TerminalNode FLAT() { return getToken(GLSLParser.FLAT, 0); }
		public TerminalNode NOPERSPECTIVE() { return getToken(GLSLParser.NOPERSPECTIVE, 0); }
		public InterpolationQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interpolationQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInterpolationQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInterpolationQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitInterpolationQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterpolationQualifierContext interpolationQualifier() throws RecognitionException {
		InterpolationQualifierContext _localctx = new InterpolationQualifierContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_interpolationQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 8437760L) != 0) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class InvariantQualifierContext extends ParserRuleContext {
		public TerminalNode INVARIANT() { return getToken(GLSLParser.INVARIANT, 0); }
		public InvariantQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariantQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInvariantQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInvariantQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitInvariantQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvariantQualifierContext invariantQualifier() throws RecognitionException {
		InvariantQualifierContext _localctx = new InvariantQualifierContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_invariantQualifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(INVARIANT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PreciseQualifierContext extends ParserRuleContext {
		public TerminalNode PRECISE() { return getToken(GLSLParser.PRECISE, 0); }
		public PreciseQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preciseQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPreciseQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPreciseQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitPreciseQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreciseQualifierContext preciseQualifier() throws RecognitionException {
		PreciseQualifierContext _localctx = new PreciseQualifierContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_preciseQualifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(PRECISE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeQualifierContext extends ParserRuleContext {
		public List<StorageQualifierContext> storageQualifier() {
			return getRuleContexts(StorageQualifierContext.class);
		}
		public StorageQualifierContext storageQualifier(int i) {
			return getRuleContext(StorageQualifierContext.class,i);
		}
		public List<LayoutQualifierContext> layoutQualifier() {
			return getRuleContexts(LayoutQualifierContext.class);
		}
		public LayoutQualifierContext layoutQualifier(int i) {
			return getRuleContext(LayoutQualifierContext.class,i);
		}
		public List<PrecisionQualifierContext> precisionQualifier() {
			return getRuleContexts(PrecisionQualifierContext.class);
		}
		public PrecisionQualifierContext precisionQualifier(int i) {
			return getRuleContext(PrecisionQualifierContext.class,i);
		}
		public List<InterpolationQualifierContext> interpolationQualifier() {
			return getRuleContexts(InterpolationQualifierContext.class);
		}
		public InterpolationQualifierContext interpolationQualifier(int i) {
			return getRuleContext(InterpolationQualifierContext.class,i);
		}
		public List<InvariantQualifierContext> invariantQualifier() {
			return getRuleContexts(InvariantQualifierContext.class);
		}
		public InvariantQualifierContext invariantQualifier(int i) {
			return getRuleContext(InvariantQualifierContext.class,i);
		}
		public List<PreciseQualifierContext> preciseQualifier() {
			return getRuleContexts(PreciseQualifierContext.class);
		}
		public PreciseQualifierContext preciseQualifier(int i) {
			return getRuleContext(PreciseQualifierContext.class,i);
		}
		public TypeQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterTypeQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitTypeQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitTypeQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeQualifierContext typeQualifier() throws RecognitionException {
		TypeQualifierContext _localctx = new TypeQualifierContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_typeQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(477);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case UNIFORM:
				case BUFFER:
				case IN:
				case OUT:
				case INOUT:
				case CONST:
				case CENTROID:
				case ATTRIBUTE:
				case VOLATILE:
				case VARYING:
				case SHARED:
				case SAMPLE:
				case PATCH:
				case COHERENT:
				case RESTRICT:
				case READONLY:
				case WRITEONLY:
				case SUBROUTINE:
				case DEVICECOHERENT:
				case QUEUEFAMILYCOHERENT:
				case WORKGROUPCOHERENT:
				case SUBGROUPCOHERENT:
				case NONPRIVATE:
				case RAY_PAYLOAD_EXT:
				case RAY_PAYLOAD_IN_EXT:
				case HIT_ATTRIBUTE_EXT:
				case CALLABLE_DATA_EXT:
				case CALLABLE_DATA_IN_EXT:
					{
					setState(471);
					storageQualifier();
					}
					break;
				case LAYOUT:
					{
					setState(472);
					layoutQualifier();
					}
					break;
				case HIGHP:
				case MEDIUMP:
				case LOWP:
					{
					setState(473);
					precisionQualifier();
					}
					break;
				case SMOOTH:
				case FLAT:
				case NOPERSPECTIVE:
					{
					setState(474);
					interpolationQualifier();
					}
					break;
				case INVARIANT:
					{
					setState(475);
					invariantQualifier();
					}
					break;
				case PRECISE:
					{
					setState(476);
					preciseQualifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 2199019060220L) != 0 );
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public BuiltinTypeSpecifierFixedContext builtinTypeSpecifierFixed() {
			return getRuleContext(BuiltinTypeSpecifierFixedContext.class,0);
		}
		public BuiltinTypeSpecifierParseableContext builtinTypeSpecifierParseable() {
			return getRuleContext(BuiltinTypeSpecifierParseableContext.class,0);
		}
		public StructSpecifierContext structSpecifier() {
			return getRuleContext(StructSpecifierContext.class,0);
		}
		public ArraySpecifierContext arraySpecifier() {
			return getRuleContext(ArraySpecifierContext.class,0);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_typeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(481);
				match(IDENTIFIER);
				}
				break;
			case ACCELERATION_STRUCTURE_EXT:
			case ATOMIC_UINT:
			case IMAGE1D:
			case IMAGE2D:
			case IMAGE3D:
			case UIMAGE1D:
			case UIMAGE2D:
			case UIMAGE3D:
			case IIMAGE1D:
			case IIMAGE2D:
			case IIMAGE3D:
			case SAMPLER1D:
			case SAMPLER2D:
			case SAMPLER3D:
			case SAMPLER2DRECT:
			case SAMPLER1DSHADOW:
			case SAMPLER2DSHADOW:
			case SAMPLER2DRECTSHADOW:
			case SAMPLER1DARRAY:
			case SAMPLER2DARRAY:
			case SAMPLER1DARRAYSHADOW:
			case SAMPLER2DARRAYSHADOW:
			case ISAMPLER1D:
			case ISAMPLER2D:
			case ISAMPLER2DRECT:
			case ISAMPLER3D:
			case ISAMPLER1DARRAY:
			case ISAMPLER2DARRAY:
			case USAMPLER1D:
			case USAMPLER2D:
			case USAMPLER2DRECT:
			case USAMPLER3D:
			case USAMPLER1DARRAY:
			case USAMPLER2DARRAY:
			case SAMPLER2DMS:
			case ISAMPLER2DMS:
			case USAMPLER2DMS:
			case SAMPLER2DMSARRAY:
			case ISAMPLER2DMSARRAY:
			case USAMPLER2DMSARRAY:
			case IMAGE2DRECT:
			case IMAGE1DARRAY:
			case IMAGE2DARRAY:
			case IMAGE2DMS:
			case IMAGE2DMSARRAY:
			case IIMAGE2DRECT:
			case IIMAGE1DARRAY:
			case IIMAGE2DARRAY:
			case IIMAGE2DMS:
			case IIMAGE2DMSARRAY:
			case UIMAGE2DRECT:
			case UIMAGE1DARRAY:
			case UIMAGE2DARRAY:
			case UIMAGE2DMS:
			case UIMAGE2DMSARRAY:
			case SAMPLERCUBESHADOW:
			case SAMPLERCUBEARRAYSHADOW:
			case SAMPLERCUBE:
			case ISAMPLERCUBE:
			case USAMPLERCUBE:
			case SAMPLERBUFFER:
			case ISAMPLERBUFFER:
			case USAMPLERBUFFER:
			case SAMPLERCUBEARRAY:
			case ISAMPLERCUBEARRAY:
			case USAMPLERCUBEARRAY:
			case IMAGECUBE:
			case UIMAGECUBE:
			case IIMAGECUBE:
			case IMAGEBUFFER:
			case IIMAGEBUFFER:
			case UIMAGEBUFFER:
			case IMAGECUBEARRAY:
			case IIMAGECUBEARRAY:
			case UIMAGECUBEARRAY:
			case VOID:
				{
				setState(482);
				builtinTypeSpecifierFixed();
				}
				break;
			case BOOL:
			case BVEC2:
			case BVEC3:
			case BVEC4:
			case INT8:
			case I8VEC2:
			case I8VEC3:
			case I8VEC4:
			case UINT8:
			case U8VEC2:
			case U8VEC3:
			case U8VEC4:
			case INT16:
			case I16VEC2:
			case I16VEC3:
			case I16VEC4:
			case UINT16:
			case U16VEC2:
			case U16VEC3:
			case U16VEC4:
			case INT32:
			case I32VEC2:
			case I32VEC3:
			case I32VEC4:
			case UINT32:
			case U32VEC2:
			case U32VEC3:
			case U32VEC4:
			case INT64:
			case I64VEC2:
			case I64VEC3:
			case I64VEC4:
			case UINT64:
			case U64VEC2:
			case U64VEC3:
			case U64VEC4:
			case FLOAT16:
			case F16VEC2:
			case F16VEC3:
			case F16VEC4:
			case F16MAT2X2:
			case F16MAT2X3:
			case F16MAT2X4:
			case F16MAT3X2:
			case F16MAT3X3:
			case F16MAT3X4:
			case F16MAT4X2:
			case F16MAT4X3:
			case F16MAT4X4:
			case FLOAT32:
			case F32VEC2:
			case F32VEC3:
			case F32VEC4:
			case F32MAT2X2:
			case F32MAT2X3:
			case F32MAT2X4:
			case F32MAT3X2:
			case F32MAT3X3:
			case F32MAT3X4:
			case F32MAT4X2:
			case F32MAT4X3:
			case F32MAT4X4:
			case FLOAT64:
			case F64VEC2:
			case F64VEC3:
			case F64VEC4:
			case F64MAT2X2:
			case F64MAT2X3:
			case F64MAT2X4:
			case F64MAT3X2:
			case F64MAT3X3:
			case F64MAT3X4:
			case F64MAT4X2:
			case F64MAT4X3:
			case F64MAT4X4:
				{
				setState(483);
				builtinTypeSpecifierParseable();
				}
				break;
			case STRUCT:
				{
				setState(484);
				structSpecifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(487);
				arraySpecifier();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArraySpecifierContext extends ParserRuleContext {
		public List<ArraySpecifierSegmentContext> arraySpecifierSegment() {
			return getRuleContexts(ArraySpecifierSegmentContext.class);
		}
		public ArraySpecifierSegmentContext arraySpecifierSegment(int i) {
			return getRuleContext(ArraySpecifierSegmentContext.class,i);
		}
		public ArraySpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraySpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterArraySpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitArraySpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitArraySpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraySpecifierContext arraySpecifier() throws RecognitionException {
		ArraySpecifierContext _localctx = new ArraySpecifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_arraySpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(490);
				arraySpecifierSegment();
				}
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBRACKET );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArraySpecifierSegmentContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(GLSLParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(GLSLParser.RBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArraySpecifierSegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraySpecifierSegment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterArraySpecifierSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitArraySpecifierSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitArraySpecifierSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraySpecifierSegmentContext arraySpecifierSegment() throws RecognitionException {
		ArraySpecifierSegmentContext _localctx = new ArraySpecifierSegmentContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arraySpecifierSegment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(495);
			match(LBRACKET);
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & -65529L) != 0 || (((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & -1L) != 0 || (((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & 562949953421311L) != 0 || (((_la - 239)) & ~0x3f) == 0 && ((1L << (_la - 239)) & 134225409L) != 0) {
				{
				setState(496);
				expression();
				}
			}

			setState(499);
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BuiltinTypeSpecifierParseableContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(GLSLParser.BOOL, 0); }
		public TerminalNode BVEC2() { return getToken(GLSLParser.BVEC2, 0); }
		public TerminalNode BVEC3() { return getToken(GLSLParser.BVEC3, 0); }
		public TerminalNode BVEC4() { return getToken(GLSLParser.BVEC4, 0); }
		public TerminalNode FLOAT16() { return getToken(GLSLParser.FLOAT16, 0); }
		public TerminalNode F16VEC2() { return getToken(GLSLParser.F16VEC2, 0); }
		public TerminalNode F16VEC3() { return getToken(GLSLParser.F16VEC3, 0); }
		public TerminalNode F16VEC4() { return getToken(GLSLParser.F16VEC4, 0); }
		public TerminalNode F16MAT2X2() { return getToken(GLSLParser.F16MAT2X2, 0); }
		public TerminalNode F16MAT2X3() { return getToken(GLSLParser.F16MAT2X3, 0); }
		public TerminalNode F16MAT2X4() { return getToken(GLSLParser.F16MAT2X4, 0); }
		public TerminalNode F16MAT3X2() { return getToken(GLSLParser.F16MAT3X2, 0); }
		public TerminalNode F16MAT3X3() { return getToken(GLSLParser.F16MAT3X3, 0); }
		public TerminalNode F16MAT3X4() { return getToken(GLSLParser.F16MAT3X4, 0); }
		public TerminalNode F16MAT4X2() { return getToken(GLSLParser.F16MAT4X2, 0); }
		public TerminalNode F16MAT4X3() { return getToken(GLSLParser.F16MAT4X3, 0); }
		public TerminalNode F16MAT4X4() { return getToken(GLSLParser.F16MAT4X4, 0); }
		public TerminalNode FLOAT32() { return getToken(GLSLParser.FLOAT32, 0); }
		public TerminalNode F32VEC2() { return getToken(GLSLParser.F32VEC2, 0); }
		public TerminalNode F32VEC3() { return getToken(GLSLParser.F32VEC3, 0); }
		public TerminalNode F32VEC4() { return getToken(GLSLParser.F32VEC4, 0); }
		public TerminalNode F32MAT2X2() { return getToken(GLSLParser.F32MAT2X2, 0); }
		public TerminalNode F32MAT2X3() { return getToken(GLSLParser.F32MAT2X3, 0); }
		public TerminalNode F32MAT2X4() { return getToken(GLSLParser.F32MAT2X4, 0); }
		public TerminalNode F32MAT3X2() { return getToken(GLSLParser.F32MAT3X2, 0); }
		public TerminalNode F32MAT3X3() { return getToken(GLSLParser.F32MAT3X3, 0); }
		public TerminalNode F32MAT3X4() { return getToken(GLSLParser.F32MAT3X4, 0); }
		public TerminalNode F32MAT4X2() { return getToken(GLSLParser.F32MAT4X2, 0); }
		public TerminalNode F32MAT4X3() { return getToken(GLSLParser.F32MAT4X3, 0); }
		public TerminalNode F32MAT4X4() { return getToken(GLSLParser.F32MAT4X4, 0); }
		public TerminalNode FLOAT64() { return getToken(GLSLParser.FLOAT64, 0); }
		public TerminalNode F64VEC2() { return getToken(GLSLParser.F64VEC2, 0); }
		public TerminalNode F64VEC3() { return getToken(GLSLParser.F64VEC3, 0); }
		public TerminalNode F64VEC4() { return getToken(GLSLParser.F64VEC4, 0); }
		public TerminalNode F64MAT2X2() { return getToken(GLSLParser.F64MAT2X2, 0); }
		public TerminalNode F64MAT2X3() { return getToken(GLSLParser.F64MAT2X3, 0); }
		public TerminalNode F64MAT2X4() { return getToken(GLSLParser.F64MAT2X4, 0); }
		public TerminalNode F64MAT3X2() { return getToken(GLSLParser.F64MAT3X2, 0); }
		public TerminalNode F64MAT3X3() { return getToken(GLSLParser.F64MAT3X3, 0); }
		public TerminalNode F64MAT3X4() { return getToken(GLSLParser.F64MAT3X4, 0); }
		public TerminalNode F64MAT4X2() { return getToken(GLSLParser.F64MAT4X2, 0); }
		public TerminalNode F64MAT4X3() { return getToken(GLSLParser.F64MAT4X3, 0); }
		public TerminalNode F64MAT4X4() { return getToken(GLSLParser.F64MAT4X4, 0); }
		public TerminalNode INT8() { return getToken(GLSLParser.INT8, 0); }
		public TerminalNode I8VEC2() { return getToken(GLSLParser.I8VEC2, 0); }
		public TerminalNode I8VEC3() { return getToken(GLSLParser.I8VEC3, 0); }
		public TerminalNode I8VEC4() { return getToken(GLSLParser.I8VEC4, 0); }
		public TerminalNode UINT8() { return getToken(GLSLParser.UINT8, 0); }
		public TerminalNode U8VEC2() { return getToken(GLSLParser.U8VEC2, 0); }
		public TerminalNode U8VEC3() { return getToken(GLSLParser.U8VEC3, 0); }
		public TerminalNode U8VEC4() { return getToken(GLSLParser.U8VEC4, 0); }
		public TerminalNode INT16() { return getToken(GLSLParser.INT16, 0); }
		public TerminalNode I16VEC2() { return getToken(GLSLParser.I16VEC2, 0); }
		public TerminalNode I16VEC3() { return getToken(GLSLParser.I16VEC3, 0); }
		public TerminalNode I16VEC4() { return getToken(GLSLParser.I16VEC4, 0); }
		public TerminalNode UINT16() { return getToken(GLSLParser.UINT16, 0); }
		public TerminalNode U16VEC2() { return getToken(GLSLParser.U16VEC2, 0); }
		public TerminalNode U16VEC3() { return getToken(GLSLParser.U16VEC3, 0); }
		public TerminalNode U16VEC4() { return getToken(GLSLParser.U16VEC4, 0); }
		public TerminalNode INT32() { return getToken(GLSLParser.INT32, 0); }
		public TerminalNode I32VEC2() { return getToken(GLSLParser.I32VEC2, 0); }
		public TerminalNode I32VEC3() { return getToken(GLSLParser.I32VEC3, 0); }
		public TerminalNode I32VEC4() { return getToken(GLSLParser.I32VEC4, 0); }
		public TerminalNode UINT32() { return getToken(GLSLParser.UINT32, 0); }
		public TerminalNode U32VEC2() { return getToken(GLSLParser.U32VEC2, 0); }
		public TerminalNode U32VEC3() { return getToken(GLSLParser.U32VEC3, 0); }
		public TerminalNode U32VEC4() { return getToken(GLSLParser.U32VEC4, 0); }
		public TerminalNode INT64() { return getToken(GLSLParser.INT64, 0); }
		public TerminalNode I64VEC2() { return getToken(GLSLParser.I64VEC2, 0); }
		public TerminalNode I64VEC3() { return getToken(GLSLParser.I64VEC3, 0); }
		public TerminalNode I64VEC4() { return getToken(GLSLParser.I64VEC4, 0); }
		public TerminalNode UINT64() { return getToken(GLSLParser.UINT64, 0); }
		public TerminalNode U64VEC2() { return getToken(GLSLParser.U64VEC2, 0); }
		public TerminalNode U64VEC3() { return getToken(GLSLParser.U64VEC3, 0); }
		public TerminalNode U64VEC4() { return getToken(GLSLParser.U64VEC4, 0); }
		public BuiltinTypeSpecifierParseableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinTypeSpecifierParseable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterBuiltinTypeSpecifierParseable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitBuiltinTypeSpecifierParseable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitBuiltinTypeSpecifierParseable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinTypeSpecifierParseableContext builtinTypeSpecifierParseable() throws RecognitionException {
		BuiltinTypeSpecifierParseableContext _localctx = new BuiltinTypeSpecifierParseableContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_builtinTypeSpecifierParseable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			_la = _input.LA(1);
			if ( !((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -1L) != 0 || (((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 2047L) != 0) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class BuiltinTypeSpecifierFixedContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(GLSLParser.VOID, 0); }
		public TerminalNode ATOMIC_UINT() { return getToken(GLSLParser.ATOMIC_UINT, 0); }
		public TerminalNode SAMPLER2D() { return getToken(GLSLParser.SAMPLER2D, 0); }
		public TerminalNode SAMPLER3D() { return getToken(GLSLParser.SAMPLER3D, 0); }
		public TerminalNode SAMPLERCUBE() { return getToken(GLSLParser.SAMPLERCUBE, 0); }
		public TerminalNode SAMPLER2DSHADOW() { return getToken(GLSLParser.SAMPLER2DSHADOW, 0); }
		public TerminalNode SAMPLERCUBESHADOW() { return getToken(GLSLParser.SAMPLERCUBESHADOW, 0); }
		public TerminalNode SAMPLER2DARRAY() { return getToken(GLSLParser.SAMPLER2DARRAY, 0); }
		public TerminalNode SAMPLER2DARRAYSHADOW() { return getToken(GLSLParser.SAMPLER2DARRAYSHADOW, 0); }
		public TerminalNode SAMPLERCUBEARRAY() { return getToken(GLSLParser.SAMPLERCUBEARRAY, 0); }
		public TerminalNode SAMPLERCUBEARRAYSHADOW() { return getToken(GLSLParser.SAMPLERCUBEARRAYSHADOW, 0); }
		public TerminalNode ISAMPLER2D() { return getToken(GLSLParser.ISAMPLER2D, 0); }
		public TerminalNode ISAMPLER3D() { return getToken(GLSLParser.ISAMPLER3D, 0); }
		public TerminalNode ISAMPLERCUBE() { return getToken(GLSLParser.ISAMPLERCUBE, 0); }
		public TerminalNode ISAMPLER2DARRAY() { return getToken(GLSLParser.ISAMPLER2DARRAY, 0); }
		public TerminalNode ISAMPLERCUBEARRAY() { return getToken(GLSLParser.ISAMPLERCUBEARRAY, 0); }
		public TerminalNode USAMPLER2D() { return getToken(GLSLParser.USAMPLER2D, 0); }
		public TerminalNode USAMPLER3D() { return getToken(GLSLParser.USAMPLER3D, 0); }
		public TerminalNode USAMPLERCUBE() { return getToken(GLSLParser.USAMPLERCUBE, 0); }
		public TerminalNode USAMPLER2DARRAY() { return getToken(GLSLParser.USAMPLER2DARRAY, 0); }
		public TerminalNode USAMPLERCUBEARRAY() { return getToken(GLSLParser.USAMPLERCUBEARRAY, 0); }
		public TerminalNode SAMPLER1D() { return getToken(GLSLParser.SAMPLER1D, 0); }
		public TerminalNode SAMPLER1DSHADOW() { return getToken(GLSLParser.SAMPLER1DSHADOW, 0); }
		public TerminalNode SAMPLER1DARRAY() { return getToken(GLSLParser.SAMPLER1DARRAY, 0); }
		public TerminalNode SAMPLER1DARRAYSHADOW() { return getToken(GLSLParser.SAMPLER1DARRAYSHADOW, 0); }
		public TerminalNode ISAMPLER1D() { return getToken(GLSLParser.ISAMPLER1D, 0); }
		public TerminalNode ISAMPLER1DARRAY() { return getToken(GLSLParser.ISAMPLER1DARRAY, 0); }
		public TerminalNode USAMPLER1D() { return getToken(GLSLParser.USAMPLER1D, 0); }
		public TerminalNode USAMPLER1DARRAY() { return getToken(GLSLParser.USAMPLER1DARRAY, 0); }
		public TerminalNode SAMPLER2DRECT() { return getToken(GLSLParser.SAMPLER2DRECT, 0); }
		public TerminalNode SAMPLER2DRECTSHADOW() { return getToken(GLSLParser.SAMPLER2DRECTSHADOW, 0); }
		public TerminalNode ISAMPLER2DRECT() { return getToken(GLSLParser.ISAMPLER2DRECT, 0); }
		public TerminalNode USAMPLER2DRECT() { return getToken(GLSLParser.USAMPLER2DRECT, 0); }
		public TerminalNode SAMPLERBUFFER() { return getToken(GLSLParser.SAMPLERBUFFER, 0); }
		public TerminalNode ISAMPLERBUFFER() { return getToken(GLSLParser.ISAMPLERBUFFER, 0); }
		public TerminalNode USAMPLERBUFFER() { return getToken(GLSLParser.USAMPLERBUFFER, 0); }
		public TerminalNode SAMPLER2DMS() { return getToken(GLSLParser.SAMPLER2DMS, 0); }
		public TerminalNode ISAMPLER2DMS() { return getToken(GLSLParser.ISAMPLER2DMS, 0); }
		public TerminalNode USAMPLER2DMS() { return getToken(GLSLParser.USAMPLER2DMS, 0); }
		public TerminalNode SAMPLER2DMSARRAY() { return getToken(GLSLParser.SAMPLER2DMSARRAY, 0); }
		public TerminalNode ISAMPLER2DMSARRAY() { return getToken(GLSLParser.ISAMPLER2DMSARRAY, 0); }
		public TerminalNode USAMPLER2DMSARRAY() { return getToken(GLSLParser.USAMPLER2DMSARRAY, 0); }
		public TerminalNode IMAGE2D() { return getToken(GLSLParser.IMAGE2D, 0); }
		public TerminalNode IIMAGE2D() { return getToken(GLSLParser.IIMAGE2D, 0); }
		public TerminalNode UIMAGE2D() { return getToken(GLSLParser.UIMAGE2D, 0); }
		public TerminalNode IMAGE3D() { return getToken(GLSLParser.IMAGE3D, 0); }
		public TerminalNode IIMAGE3D() { return getToken(GLSLParser.IIMAGE3D, 0); }
		public TerminalNode UIMAGE3D() { return getToken(GLSLParser.UIMAGE3D, 0); }
		public TerminalNode IMAGECUBE() { return getToken(GLSLParser.IMAGECUBE, 0); }
		public TerminalNode IIMAGECUBE() { return getToken(GLSLParser.IIMAGECUBE, 0); }
		public TerminalNode UIMAGECUBE() { return getToken(GLSLParser.UIMAGECUBE, 0); }
		public TerminalNode IMAGEBUFFER() { return getToken(GLSLParser.IMAGEBUFFER, 0); }
		public TerminalNode IIMAGEBUFFER() { return getToken(GLSLParser.IIMAGEBUFFER, 0); }
		public TerminalNode UIMAGEBUFFER() { return getToken(GLSLParser.UIMAGEBUFFER, 0); }
		public TerminalNode IMAGE1D() { return getToken(GLSLParser.IMAGE1D, 0); }
		public TerminalNode IIMAGE1D() { return getToken(GLSLParser.IIMAGE1D, 0); }
		public TerminalNode UIMAGE1D() { return getToken(GLSLParser.UIMAGE1D, 0); }
		public TerminalNode IMAGE1DARRAY() { return getToken(GLSLParser.IMAGE1DARRAY, 0); }
		public TerminalNode IIMAGE1DARRAY() { return getToken(GLSLParser.IIMAGE1DARRAY, 0); }
		public TerminalNode UIMAGE1DARRAY() { return getToken(GLSLParser.UIMAGE1DARRAY, 0); }
		public TerminalNode IMAGE2DRECT() { return getToken(GLSLParser.IMAGE2DRECT, 0); }
		public TerminalNode IIMAGE2DRECT() { return getToken(GLSLParser.IIMAGE2DRECT, 0); }
		public TerminalNode UIMAGE2DRECT() { return getToken(GLSLParser.UIMAGE2DRECT, 0); }
		public TerminalNode IMAGE2DARRAY() { return getToken(GLSLParser.IMAGE2DARRAY, 0); }
		public TerminalNode IIMAGE2DARRAY() { return getToken(GLSLParser.IIMAGE2DARRAY, 0); }
		public TerminalNode UIMAGE2DARRAY() { return getToken(GLSLParser.UIMAGE2DARRAY, 0); }
		public TerminalNode IMAGECUBEARRAY() { return getToken(GLSLParser.IMAGECUBEARRAY, 0); }
		public TerminalNode IIMAGECUBEARRAY() { return getToken(GLSLParser.IIMAGECUBEARRAY, 0); }
		public TerminalNode UIMAGECUBEARRAY() { return getToken(GLSLParser.UIMAGECUBEARRAY, 0); }
		public TerminalNode IMAGE2DMS() { return getToken(GLSLParser.IMAGE2DMS, 0); }
		public TerminalNode IIMAGE2DMS() { return getToken(GLSLParser.IIMAGE2DMS, 0); }
		public TerminalNode UIMAGE2DMS() { return getToken(GLSLParser.UIMAGE2DMS, 0); }
		public TerminalNode IMAGE2DMSARRAY() { return getToken(GLSLParser.IMAGE2DMSARRAY, 0); }
		public TerminalNode IIMAGE2DMSARRAY() { return getToken(GLSLParser.IIMAGE2DMSARRAY, 0); }
		public TerminalNode UIMAGE2DMSARRAY() { return getToken(GLSLParser.UIMAGE2DMSARRAY, 0); }
		public TerminalNode ACCELERATION_STRUCTURE_EXT() { return getToken(GLSLParser.ACCELERATION_STRUCTURE_EXT, 0); }
		public BuiltinTypeSpecifierFixedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinTypeSpecifierFixed; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterBuiltinTypeSpecifierFixed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitBuiltinTypeSpecifierFixed(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitBuiltinTypeSpecifierFixed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinTypeSpecifierFixedContext builtinTypeSpecifierFixed() throws RecognitionException {
		BuiltinTypeSpecifierFixedContext _localctx = new BuiltinTypeSpecifierFixedContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_builtinTypeSpecifierFixed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_la = _input.LA(1);
			if ( !(_la==ACCELERATION_STRUCTURE_EXT || _la==ATOMIC_UINT || (((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & -1L) != 0 || (((_la - 208)) & ~0x3f) == 0 && ((1L << (_la - 208)) & 2559L) != 0) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructSpecifierContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(GLSLParser.STRUCT, 0); }
		public StructBodyContext structBody() {
			return getRuleContext(StructBodyContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public StructSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStructSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStructSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitStructSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructSpecifierContext structSpecifier() throws RecognitionException {
		StructSpecifierContext _localctx = new StructSpecifierContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_structSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(STRUCT);
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(506);
				match(IDENTIFIER);
				}
			}

			setState(509);
			structBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(GLSLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(GLSLParser.RBRACE, 0); }
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public StructBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStructBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStructBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitStructBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructBodyContext structBody() throws RecognitionException {
		StructBodyContext _localctx = new StructBodyContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_structBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(LBRACE);
			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(512);
				structMember();
				}
				}
				setState(515);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 63771670215676L) != 0 || (((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -1L) != 0 || (((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & -1L) != 0 || (((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & 5242879L) != 0 || _la==IDENTIFIER );
			setState(517);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructMemberContext extends ParserRuleContext {
		public StructDeclaratorContext structDeclarator;
		public List<StructDeclaratorContext> structDeclarators = new ArrayList<StructDeclaratorContext>();
		public FullySpecifiedTypeContext fullySpecifiedType() {
			return getRuleContext(FullySpecifiedTypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public List<StructDeclaratorContext> structDeclarator() {
			return getRuleContexts(StructDeclaratorContext.class);
		}
		public StructDeclaratorContext structDeclarator(int i) {
			return getRuleContext(StructDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStructMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStructMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitStructMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			fullySpecifiedType();
			setState(520);
			((StructMemberContext)_localctx).structDeclarator = structDeclarator();
			((StructMemberContext)_localctx).structDeclarators.add(((StructMemberContext)_localctx).structDeclarator);
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(521);
				match(COMMA);
				setState(522);
				((StructMemberContext)_localctx).structDeclarator = structDeclarator();
				((StructMemberContext)_localctx).structDeclarators.add(((StructMemberContext)_localctx).structDeclarator);
				}
				}
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(528);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclaratorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public ArraySpecifierContext arraySpecifier() {
			return getRuleContext(ArraySpecifierContext.class,0);
		}
		public StructDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStructDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStructDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitStructDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclaratorContext structDeclarator() throws RecognitionException {
		StructDeclaratorContext _localctx = new StructDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_structDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(IDENTIFIER);
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(531);
				arraySpecifier();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends ParserRuleContext {
		public InitializerContext initializer;
		public List<InitializerContext> initializers = new ArrayList<InitializerContext>();
		public FiniteExpressionContext finiteExpression() {
			return getRuleContext(FiniteExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(GLSLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(GLSLParser.RBRACE, 0); }
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_initializer);
		int _la;
		try {
			int _alt;
			setState(550);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ACCELERATION_STRUCTURE_EXT:
			case ATOMIC_UINT:
			case STRUCT:
			case UINT16CONSTANT:
			case INT16CONSTANT:
			case UINT32CONSTANT:
			case INT32CONSTANT:
			case UINT64CONSTANT:
			case INT64CONSTANT:
			case FLOAT16CONSTANT:
			case FLOAT32CONSTANT:
			case FLOAT64CONSTANT:
			case BOOLCONSTANT:
			case BOOL:
			case BVEC2:
			case BVEC3:
			case BVEC4:
			case INT8:
			case I8VEC2:
			case I8VEC3:
			case I8VEC4:
			case UINT8:
			case U8VEC2:
			case U8VEC3:
			case U8VEC4:
			case INT16:
			case I16VEC2:
			case I16VEC3:
			case I16VEC4:
			case UINT16:
			case U16VEC2:
			case U16VEC3:
			case U16VEC4:
			case INT32:
			case I32VEC2:
			case I32VEC3:
			case I32VEC4:
			case UINT32:
			case U32VEC2:
			case U32VEC3:
			case U32VEC4:
			case INT64:
			case I64VEC2:
			case I64VEC3:
			case I64VEC4:
			case UINT64:
			case U64VEC2:
			case U64VEC3:
			case U64VEC4:
			case FLOAT16:
			case F16VEC2:
			case F16VEC3:
			case F16VEC4:
			case F16MAT2X2:
			case F16MAT2X3:
			case F16MAT2X4:
			case F16MAT3X2:
			case F16MAT3X3:
			case F16MAT3X4:
			case F16MAT4X2:
			case F16MAT4X3:
			case F16MAT4X4:
			case FLOAT32:
			case F32VEC2:
			case F32VEC3:
			case F32VEC4:
			case F32MAT2X2:
			case F32MAT2X3:
			case F32MAT2X4:
			case F32MAT3X2:
			case F32MAT3X3:
			case F32MAT3X4:
			case F32MAT4X2:
			case F32MAT4X3:
			case F32MAT4X4:
			case FLOAT64:
			case F64VEC2:
			case F64VEC3:
			case F64VEC4:
			case F64MAT2X2:
			case F64MAT2X3:
			case F64MAT2X4:
			case F64MAT3X2:
			case F64MAT3X3:
			case F64MAT3X4:
			case F64MAT4X2:
			case F64MAT4X3:
			case F64MAT4X4:
			case IMAGE1D:
			case IMAGE2D:
			case IMAGE3D:
			case UIMAGE1D:
			case UIMAGE2D:
			case UIMAGE3D:
			case IIMAGE1D:
			case IIMAGE2D:
			case IIMAGE3D:
			case SAMPLER1D:
			case SAMPLER2D:
			case SAMPLER3D:
			case SAMPLER2DRECT:
			case SAMPLER1DSHADOW:
			case SAMPLER2DSHADOW:
			case SAMPLER2DRECTSHADOW:
			case SAMPLER1DARRAY:
			case SAMPLER2DARRAY:
			case SAMPLER1DARRAYSHADOW:
			case SAMPLER2DARRAYSHADOW:
			case ISAMPLER1D:
			case ISAMPLER2D:
			case ISAMPLER2DRECT:
			case ISAMPLER3D:
			case ISAMPLER1DARRAY:
			case ISAMPLER2DARRAY:
			case USAMPLER1D:
			case USAMPLER2D:
			case USAMPLER2DRECT:
			case USAMPLER3D:
			case USAMPLER1DARRAY:
			case USAMPLER2DARRAY:
			case SAMPLER2DMS:
			case ISAMPLER2DMS:
			case USAMPLER2DMS:
			case SAMPLER2DMSARRAY:
			case ISAMPLER2DMSARRAY:
			case USAMPLER2DMSARRAY:
			case IMAGE2DRECT:
			case IMAGE1DARRAY:
			case IMAGE2DARRAY:
			case IMAGE2DMS:
			case IMAGE2DMSARRAY:
			case IIMAGE2DRECT:
			case IIMAGE1DARRAY:
			case IIMAGE2DARRAY:
			case IIMAGE2DMS:
			case IIMAGE2DMSARRAY:
			case UIMAGE2DRECT:
			case UIMAGE1DARRAY:
			case UIMAGE2DARRAY:
			case UIMAGE2DMS:
			case UIMAGE2DMSARRAY:
			case SAMPLERCUBESHADOW:
			case SAMPLERCUBEARRAYSHADOW:
			case SAMPLERCUBE:
			case ISAMPLERCUBE:
			case USAMPLERCUBE:
			case SAMPLERBUFFER:
			case ISAMPLERBUFFER:
			case USAMPLERBUFFER:
			case SAMPLERCUBEARRAY:
			case ISAMPLERCUBEARRAY:
			case USAMPLERCUBEARRAY:
			case IMAGECUBE:
			case UIMAGECUBE:
			case IIMAGECUBE:
			case IMAGEBUFFER:
			case IIMAGEBUFFER:
			case UIMAGEBUFFER:
			case IMAGECUBEARRAY:
			case IIMAGECUBEARRAY:
			case UIMAGECUBEARRAY:
			case INC_OP:
			case DEC_OP:
			case VOID:
			case LPAREN:
			case PLUS_OP:
			case MINUS_OP:
			case LOGICAL_NOT_OP:
			case BITWISE_NEG_OP:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(534);
				finiteExpression(0);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				match(LBRACE);
				setState(547);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & -65529L) != 0 || (((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & -1L) != 0 || (((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & 562949953421311L) != 0 || (((_la - 239)) & ~0x3f) == 0 && ((1L << (_la - 239)) & 134225413L) != 0) {
					{
					setState(536);
					((InitializerContext)_localctx).initializer = initializer();
					((InitializerContext)_localctx).initializers.add(((InitializerContext)_localctx).initializer);
					setState(541);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
					while ( _alt!=2 && _alt!=repack.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(537);
							match(COMMA);
							setState(538);
							((InitializerContext)_localctx).initializer = initializer();
							((InitializerContext)_localctx).initializers.add(((InitializerContext)_localctx).initializer);
							}
							}
						}
						setState(543);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
					}
					setState(545);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(544);
						match(COMMA);
						}
					}

					}
				}

				setState(549);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationStatementContext declarationStatement() {
			return getRuleContext(DeclarationStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public CaseLabelContext caseLabel() {
			return getRuleContext(CaseLabelContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public DemoteStatementContext demoteStatement() {
			return getRuleContext(DemoteStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_statement);
		try {
			setState(564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(552);
				compoundStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
				declarationStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(554);
				expressionStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(555);
				emptyStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(556);
				selectionStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(557);
				switchStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(558);
				caseLabel();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(559);
				forStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(560);
				whileStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(561);
				doWhileStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(562);
				jumpStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(563);
				demoteStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(GLSLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(GLSLParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			match(LBRACE);
			setState(570);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & -140737492549636L) != 0 || (((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1L) != 0 || (((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & -1L) != 0 || (((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 1088322997720186879L) != 0 || _la==IDENTIFIER) {
				{
				{
				setState(567);
				statement();
				}
				}
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(573);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationStatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationStatementContext declarationStatement() throws RecognitionException {
		DeclarationStatementContext _localctx = new DeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_declarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			declaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			expression();
			setState(578);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectionStatementContext extends ParserRuleContext {
		public ExpressionContext condition;
		public StatementContext ifTrue;
		public StatementContext ifFalse;
		public TerminalNode IF() { return getToken(GLSLParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(GLSLParser.ELSE, 0); }
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSelectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitSelectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_selectionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(582);
				attribute();
				}
			}

			setState(585);
			match(IF);
			setState(586);
			match(LPAREN);
			setState(587);
			((SelectionStatementContext)_localctx).condition = expression();
			setState(588);
			match(RPAREN);
			setState(589);
			((SelectionStatementContext)_localctx).ifTrue = statement();
			setState(592);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(590);
				match(ELSE);
				setState(591);
				((SelectionStatementContext)_localctx).ifFalse = statement();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class IterationConditionContext extends ParserRuleContext {
		public Token name;
		public FullySpecifiedTypeContext fullySpecifiedType() {
			return getRuleContext(FullySpecifiedTypeContext.class,0);
		}
		public TerminalNode ASSIGN_OP() { return getToken(GLSLParser.ASSIGN_OP, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public IterationConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterIterationCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitIterationCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitIterationCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationConditionContext iterationCondition() throws RecognitionException {
		IterationConditionContext _localctx = new IterationConditionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_iterationCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			fullySpecifiedType();
			setState(595);
			((IterationConditionContext)_localctx).name = match(IDENTIFIER);
			setState(596);
			match(ASSIGN_OP);
			setState(597);
			initializer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementContext extends ParserRuleContext {
		public ExpressionContext condition;
		public TerminalNode SWITCH() { return getToken(GLSLParser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(599);
				attribute();
				}
			}

			setState(602);
			match(SWITCH);
			setState(603);
			match(LPAREN);
			setState(604);
			((SwitchStatementContext)_localctx).condition = expression();
			setState(605);
			match(RPAREN);
			setState(606);
			compoundStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CaseLabelContext extends ParserRuleContext {
		public CaseLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseLabel; }

		public CaseLabelContext() { }
		public void copyFrom(CaseLabelContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefaultCaseLabelContext extends CaseLabelContext {
		public TerminalNode DEFAULT() { return getToken(GLSLParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(GLSLParser.COLON, 0); }
		public DefaultCaseLabelContext(CaseLabelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterDefaultCaseLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitDefaultCaseLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitDefaultCaseLabel(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValuedCaseLabelContext extends CaseLabelContext {
		public TerminalNode CASE() { return getToken(GLSLParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GLSLParser.COLON, 0); }
		public ValuedCaseLabelContext(CaseLabelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterValuedCaseLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitValuedCaseLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitValuedCaseLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseLabelContext caseLabel() throws RecognitionException {
		CaseLabelContext _localctx = new CaseLabelContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_caseLabel);
		try {
			setState(614);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				_localctx = new ValuedCaseLabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(608);
				match(CASE);
				setState(609);
				expression();
				setState(610);
				match(COLON);
				}
				break;
			case DEFAULT:
				_localctx = new DefaultCaseLabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(612);
				match(DEFAULT);
				setState(613);
				match(COLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext condition;
		public IterationConditionContext initCondition;
		public StatementContext loopBody;
		public TerminalNode WHILE() { return getToken(GLSLParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IterationConditionContext iterationCondition() {
			return getRuleContext(IterationConditionContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_whileStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(616);
				attribute();
				}
			}

			setState(619);
			match(WHILE);
			setState(620);
			match(LPAREN);
			setState(623);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(621);
				((WhileStatementContext)_localctx).condition = expression();
				}
				break;
			case 2:
				{
				setState(622);
				((WhileStatementContext)_localctx).initCondition = iterationCondition();
				}
				break;
			}
			setState(625);
			match(RPAREN);
			setState(626);
			((WhileStatementContext)_localctx).loopBody = statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStatementContext extends ParserRuleContext {
		public StatementContext loopBody;
		public ExpressionContext condition;
		public TerminalNode DO() { return getToken(GLSLParser.DO, 0); }
		public TerminalNode WHILE() { return getToken(GLSLParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_doWhileStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(628);
				attribute();
				}
			}

			setState(631);
			match(DO);
			setState(632);
			((DoWhileStatementContext)_localctx).loopBody = statement();
			setState(633);
			match(WHILE);
			setState(634);
			match(LPAREN);
			setState(635);
			((DoWhileStatementContext)_localctx).condition = expression();
			setState(636);
			match(RPAREN);
			setState(637);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public ExpressionContext condition;
		public IterationConditionContext initCondition;
		public ExpressionContext incrementer;
		public StatementContext loopBody;
		public TerminalNode FOR() { return getToken(GLSLParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(GLSLParser.LPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public TerminalNode RPAREN() { return getToken(GLSLParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public DeclarationStatementContext declarationStatement() {
			return getRuleContext(DeclarationStatementContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IterationConditionContext iterationCondition() {
			return getRuleContext(IterationConditionContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(639);
				attribute();
				}
			}

			setState(642);
			match(FOR);
			setState(643);
			match(LPAREN);
			setState(647);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(644);
				emptyStatement();
				}
				break;
			case 2:
				{
				setState(645);
				expressionStatement();
				}
				break;
			case 3:
				{
				setState(646);
				declarationStatement();
				}
				break;
			}
			setState(651);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(649);
				((ForStatementContext)_localctx).condition = expression();
				}
				break;
			case 2:
				{
				setState(650);
				((ForStatementContext)_localctx).initCondition = iterationCondition();
				}
				break;
			}
			setState(653);
			match(SEMICOLON);
			setState(655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & -65529L) != 0 || (((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & -1L) != 0 || (((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & 562949953421311L) != 0 || (((_la - 239)) & ~0x3f) == 0 && ((1L << (_la - 239)) & 134225409L) != 0) {
				{
				setState(654);
				((ForStatementContext)_localctx).incrementer = expression();
				}
			}

			setState(657);
			match(RPAREN);
			setState(658);
			((ForStatementContext)_localctx).loopBody = statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }

		public JumpStatementContext() { }
		public void copyFrom(JumpStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IgnoreIntersectionStatementContext extends JumpStatementContext {
		public TerminalNode IGNORE_INTERSECTION_EXT() { return getToken(GLSLParser.IGNORE_INTERSECTION_EXT, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public IgnoreIntersectionStatementContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterIgnoreIntersectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitIgnoreIntersectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitIgnoreIntersectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DiscardStatementContext extends JumpStatementContext {
		public TerminalNode DISCARD() { return getToken(GLSLParser.DISCARD, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public DiscardStatementContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterDiscardStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitDiscardStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitDiscardStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TerminateRayStatementContext extends JumpStatementContext {
		public TerminalNode TERMINATE_RAY_EXT() { return getToken(GLSLParser.TERMINATE_RAY_EXT, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public TerminateRayStatementContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterTerminateRayStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitTerminateRayStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitTerminateRayStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends JumpStatementContext {
		public TerminalNode BREAK() { return getToken(GLSLParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public BreakStatementContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends JumpStatementContext {
		public TerminalNode CONTINUE() { return getToken(GLSLParser.CONTINUE, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public ContinueStatementContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends JumpStatementContext {
		public TerminalNode RETURN() { return getToken(GLSLParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_jumpStatement);
		int _la;
		try {
			setState(675);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTINUE:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(660);
				match(CONTINUE);
				setState(661);
				match(SEMICOLON);
				}
				break;
			case BREAK:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(662);
				match(BREAK);
				setState(663);
				match(SEMICOLON);
				}
				break;
			case RETURN:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(664);
				match(RETURN);
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & -65529L) != 0 || (((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & -1L) != 0 || (((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & 562949953421311L) != 0 || (((_la - 239)) & ~0x3f) == 0 && ((1L << (_la - 239)) & 134225409L) != 0) {
					{
					setState(665);
					expression();
					}
				}

				setState(668);
				match(SEMICOLON);
				}
				break;
			case DISCARD:
				_localctx = new DiscardStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(669);
				match(DISCARD);
				setState(670);
				match(SEMICOLON);
				}
				break;
			case IGNORE_INTERSECTION_EXT:
				_localctx = new IgnoreIntersectionStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(671);
				match(IGNORE_INTERSECTION_EXT);
				setState(672);
				match(SEMICOLON);
				}
				break;
			case TERMINATE_RAY_EXT:
				_localctx = new TerminateRayStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(673);
				match(TERMINATE_RAY_EXT);
				setState(674);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DemoteStatementContext extends ParserRuleContext {
		public TerminalNode DEMOTE() { return getToken(GLSLParser.DEMOTE, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public DemoteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_demoteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterDemoteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitDemoteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GLSLParserVisitor ) return ((GLSLParserVisitor<? extends T>)visitor).visitDemoteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DemoteStatementContext demoteStatement() throws RecognitionException {
		DemoteStatementContext _localctx = new DemoteStatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_demoteStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			match(DEMOTE);
			setState(678);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return finiteExpression_sempred((FiniteExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean finiteExpression_sempred(FiniteExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		case 13:
			return precpred(_ctx, 19);
		case 14:
			return precpred(_ctx, 18);
		case 15:
			return precpred(_ctx, 16);
		case 16:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u014d\u02a9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u0001\u0000\u0003\u0000j\b\u0000\u0001\u0000"+
		"\u0005\u0000m\b\u0000\n\u0000\f\u0000p\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001x\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0084\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u008b\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0096\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u009f\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00a6\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00ae\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b3\b\u0007\u0001\u0007"+
		"\u0003\u0007\u00b6\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00ca\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u00d2\b\n\n\n\f\n\u00d5\t\n\u0003\n"+
		"\u00d7\b\n\u0001\n\u0001\n\u0001\n\u0003\n\u00dc\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0114\b\n\n"+
		"\n\f\n\u0117\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u011c"+
		"\b\u000b\n\u000b\f\u000b\u011f\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0129\b\f\u0003\f\u012b\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0133\b\f\n\f\f\f\u0136"+
		"\t\f\u0003\f\u0138\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0145\b\f\n\f\f\f\u0148"+
		"\t\f\u0003\f\u014a\b\f\u0001\f\u0001\f\u0003\f\u014e\b\f\u0001\r\u0003"+
		"\r\u0151\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0159"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u015e\b\u000e\n\u000e"+
		"\f\u000e\u0161\t\u000e\u0003\u000e\u0163\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u0168\b\u000f\u0003\u000f\u016a\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0171"+
		"\b\u0010\n\u0010\f\u0010\u0174\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u017c\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0183\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u0187\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u018b\b\u0012\u0001\u0013\u0003\u0013\u018e\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005"+
		"\u0014\u01a8\b\u0014\n\u0014\f\u0014\u01ab\t\u0014\u0001\u0014\u0003\u0014"+
		"\u01ae\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u01ba\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u01c1\b\u0015\n\u0015\f\u0015\u01c4\t\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01cb\b\u0016\u0001"+
		"\u0016\u0003\u0016\u01ce\b\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0004\u001b\u01de"+
		"\b\u001b\u000b\u001b\f\u001b\u01df\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u01e6\b\u001c\u0001\u001c\u0003\u001c\u01e9\b"+
		"\u001c\u0001\u001d\u0004\u001d\u01ec\b\u001d\u000b\u001d\f\u001d\u01ed"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u01f2\b\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0003!\u01fc\b!\u0001"+
		"!\u0001!\u0001\"\u0001\"\u0004\"\u0202\b\"\u000b\"\f\"\u0203\u0001\"\u0001"+
		"\"\u0001#\u0001#\u0001#\u0001#\u0005#\u020c\b#\n#\f#\u020f\t#\u0001#\u0001"+
		"#\u0001$\u0001$\u0003$\u0215\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0005"+
		"%\u021c\b%\n%\f%\u021f\t%\u0001%\u0003%\u0222\b%\u0003%\u0224\b%\u0001"+
		"%\u0003%\u0227\b%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0003&\u0235\b&\u0001\'\u0001\'\u0005\'"+
		"\u0239\b\'\n\'\f\'\u023c\t\'\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001"+
		")\u0001)\u0001*\u0001*\u0001+\u0003+\u0248\b+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0003+\u0251\b+\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001-\u0003-\u0259\b-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0003.\u0267\b.\u0001/\u0003/\u026a"+
		"\b/\u0001/\u0001/\u0001/\u0001/\u0003/\u0270\b/\u0001/\u0001/\u0001/\u0001"+
		"0\u00030\u0276\b0\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u0001"+
		"0\u00011\u00031\u0281\b1\u00011\u00011\u00011\u00011\u00011\u00031\u0288"+
		"\b1\u00011\u00011\u00031\u028c\b1\u00011\u00011\u00031\u0290\b1\u0001"+
		"1\u00011\u00011\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u029b"+
		"\b2\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u02a4\b2\u0001"+
		"3\u00013\u00013\u00013\u0000\u0001\u00144\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdf\u0000\u0013\u0001\u0000\u0126\u0136\u0001\u0000"+
		"\u0123\u0125\u0001\u0000\u0115\u0116\u0001\u0000\u0118\u0119\u0001\u0000"+
		"\u011b\u011e\u0001\u0000\u0002\u0005\u0001\u0000;D\u0002\u0000\u00d9\u00da"+
		"\u00f8\u00fb\u0001\u0000\u00fc\u00fe\u0001\u0000\u00f8\u00f9\u0001\u0000"+
		"\u00dc\u00dd\u0002\u0000\u00de\u00df\u00ff\u0100\u0001\u0000\u00e0\u00e1"+
		"\u0002\u0000\u00e5\u00ee\u0105\u0105\u0001\u0000\u00d9\u00da\u0001\u0000"+
		"\u0007\t\u0002\u0000\u000e\u000f\u0017\u0017\u0001\u0000E\u008f\u0003"+
		"\u0000+,\u0090\u00d8\u00db\u00db\u0309\u0000i\u0001\u0000\u0000\u0000"+
		"\u0002s\u0001\u0000\u0000\u0000\u0004\u0083\u0001\u0000\u0000\u0000\u0006"+
		"\u0085\u0001\u0000\u0000\u0000\b\u0087\u0001\u0000\u0000\u0000\n\u0099"+
		"\u0001\u0000\u0000\u0000\f\u00a2\u0001\u0000\u0000\u0000\u000e\u00a9\u0001"+
		"\u0000\u0000\u0000\u0010\u00b9\u0001\u0000\u0000\u0000\u0012\u00bd\u0001"+
		"\u0000\u0000\u0000\u0014\u00db\u0001\u0000\u0000\u0000\u0016\u0118\u0001"+
		"\u0000\u0000\u0000\u0018\u014d\u0001\u0000\u0000\u0000\u001a\u0150\u0001"+
		"\u0000\u0000\u0000\u001c\u0162\u0001\u0000\u0000\u0000\u001e\u0164\u0001"+
		"\u0000\u0000\u0000 \u016b\u0001\u0000\u0000\u0000\"\u017b\u0001\u0000"+
		"\u0000\u0000$\u0184\u0001\u0000\u0000\u0000&\u018d\u0001\u0000\u0000\u0000"+
		"(\u01b9\u0001\u0000\u0000\u0000*\u01bb\u0001\u0000\u0000\u0000,\u01cd"+
		"\u0001\u0000\u0000\u0000.\u01cf\u0001\u0000\u0000\u00000\u01d1\u0001\u0000"+
		"\u0000\u00002\u01d3\u0001\u0000\u0000\u00004\u01d5\u0001\u0000\u0000\u0000"+
		"6\u01dd\u0001\u0000\u0000\u00008\u01e5\u0001\u0000\u0000\u0000:\u01eb"+
		"\u0001\u0000\u0000\u0000<\u01ef\u0001\u0000\u0000\u0000>\u01f5\u0001\u0000"+
		"\u0000\u0000@\u01f7\u0001\u0000\u0000\u0000B\u01f9\u0001\u0000\u0000\u0000"+
		"D\u01ff\u0001\u0000\u0000\u0000F\u0207\u0001\u0000\u0000\u0000H\u0212"+
		"\u0001\u0000\u0000\u0000J\u0226\u0001\u0000\u0000\u0000L\u0234\u0001\u0000"+
		"\u0000\u0000N\u0236\u0001\u0000\u0000\u0000P\u023f\u0001\u0000\u0000\u0000"+
		"R\u0241\u0001\u0000\u0000\u0000T\u0244\u0001\u0000\u0000\u0000V\u0247"+
		"\u0001\u0000\u0000\u0000X\u0252\u0001\u0000\u0000\u0000Z\u0258\u0001\u0000"+
		"\u0000\u0000\\\u0266\u0001\u0000\u0000\u0000^\u0269\u0001\u0000\u0000"+
		"\u0000`\u0275\u0001\u0000\u0000\u0000b\u0280\u0001\u0000\u0000\u0000d"+
		"\u02a3\u0001\u0000\u0000\u0000f\u02a5\u0001\u0000\u0000\u0000hj\u0003"+
		"\u0002\u0001\u0000ih\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000"+
		"jn\u0001\u0000\u0000\u0000km\u0003\u0004\u0002\u0000lk\u0001\u0000\u0000"+
		"\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000"+
		"\u0000\u0000oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005"+
		"\u0000\u0000\u0001r\u0001\u0001\u0000\u0000\u0000st\u0005\u0109\u0000"+
		"\u0000tu\u0005\u0111\u0000\u0000uw\u0007\u0000\u0000\u0000vx\u0007\u0001"+
		"\u0000\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yz\u0005\u013e\u0000\u0000z\u0003\u0001\u0000\u0000"+
		"\u0000{\u0084\u0003\u0012\t\u0000|\u0084\u0003\u0018\f\u0000}\u0084\u0003"+
		"\b\u0004\u0000~\u0084\u0003\n\u0005\u0000\u007f\u0084\u0003\f\u0006\u0000"+
		"\u0080\u0084\u0003\u000e\u0007\u0000\u0081\u0084\u0003\u0010\b\u0000\u0082"+
		"\u0084\u0003\u0006\u0003\u0000\u0083{\u0001\u0000\u0000\u0000\u0083|\u0001"+
		"\u0000\u0000\u0000\u0083}\u0001\u0000\u0000\u0000\u0083~\u0001\u0000\u0000"+
		"\u0000\u0083\u007f\u0001\u0000\u0000\u0000\u0083\u0080\u0001\u0000\u0000"+
		"\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000"+
		"\u0000\u0084\u0005\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u00f3\u0000"+
		"\u0000\u0086\u0007\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0109\u0000"+
		"\u0000\u0088\u008a\u0005\u0114\u0000\u0000\u0089\u008b\u0005\u0122\u0000"+
		"\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000"+
		"\u0000\u008b\u0095\u0001\u0000\u0000\u0000\u008c\u0096\u0005\u013a\u0000"+
		"\u0000\u008d\u008e\u0007\u0002\u0000\u0000\u008e\u008f\u0005\u0120\u0000"+
		"\u0000\u008f\u0090\u0007\u0003\u0000\u0000\u0090\u0096\u0005\u0121\u0000"+
		"\u0000\u0091\u0092\u0005\u0117\u0000\u0000\u0092\u0093\u0005\u0120\u0000"+
		"\u0000\u0093\u0094\u0005\u011a\u0000\u0000\u0094\u0096\u0005\u0121\u0000"+
		"\u0000\u0095\u008c\u0001\u0000\u0000\u0000\u0095\u008d\u0001\u0000\u0000"+
		"\u0000\u0095\u0091\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0005\u013e\u0000\u0000\u0098\t\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0005\u0109\u0000\u0000\u009a\u009b\u0005\u0110\u0000\u0000"+
		"\u009b\u009e\u0005\u013a\u0000\u0000\u009c\u009d\u0005\u011f\u0000\u0000"+
		"\u009d\u009f\u0007\u0004\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0005\u013e\u0000\u0000\u00a1\u000b\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0005\u0109\u0000\u0000\u00a3\u00a5\u0005\u0112\u0000\u0000"+
		"\u00a4\u00a6\u0005\u0148\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0005\u0146\u0000\u0000\u00a8\r\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0005\u0109\u0000\u0000\u00aa\u00b5\u0005\u0113\u0000\u0000\u00ab"+
		"\u00ad\u0005\u0137\u0000\u0000\u00ac\u00ae\u0005\u0140\u0000\u0000\u00ad"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00af\u0001\u0000\u0000\u0000\u00af\u00b6\u0005\u0141\u0000\u0000\u00b0"+
		"\u00b2\u0005\u0138\u0000\u0000\u00b1\u00b3\u0005\u0142\u0000\u0000\u00b2"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b6\u0005\u0143\u0000\u0000\u00b5"+
		"\u00ab\u0001\u0000\u0000\u0000\u00b5\u00b0\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u013e\u0000\u0000\u00b8"+
		"\u000f\u0001\u0000\u0000\u0000\u00b9\u00ba\u0003*\u0015\u0000\u00ba\u00bb"+
		"\u0007\u0005\u0000\u0000\u00bb\u00bc\u0005\u00f3\u0000\u0000\u00bc\u0011"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0003\u001a\r\u0000\u00be\u00bf\u0003"+
		"N\'\u0000\u00bf\u0013\u0001\u0000\u0000\u0000\u00c0\u00c1\u0006\n\uffff"+
		"\uffff\u0000\u00c1\u00dc\u0005\u010a\u0000\u0000\u00c2\u00dc\u0007\u0006"+
		"\u0000\u0000\u00c3\u00c4\u0005\u00ef\u0000\u0000\u00c4\u00c5\u0003\u0016"+
		"\u000b\u0000\u00c5\u00c6\u0005\u00f0\u0000\u0000\u00c6\u00dc\u0001\u0000"+
		"\u0000\u0000\u00c7\u00ca\u0005\u010a\u0000\u0000\u00c8\u00ca\u00038\u001c"+
		"\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00d6\u0005\u00ef\u0000"+
		"\u0000\u00cc\u00d7\u0001\u0000\u0000\u0000\u00cd\u00d7\u0005\u00db\u0000"+
		"\u0000\u00ce\u00d3\u0003\u0014\n\u0000\u00cf\u00d0\u0005\u00f6\u0000\u0000"+
		"\u00d0\u00d2\u0003\u0014\n\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d6\u00cc\u0001\u0000\u0000\u0000\u00d6"+
		"\u00cd\u0001\u0000\u0000\u0000\u00d6\u00ce\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d8\u0001\u0000\u0000\u0000\u00d8\u00dc\u0005\u00f0\u0000\u0000\u00d9"+
		"\u00da\u0007\u0007\u0000\u0000\u00da\u00dc\u0003\u0014\n\u000e\u00db\u00c0"+
		"\u0001\u0000\u0000\u0000\u00db\u00c2\u0001\u0000\u0000\u0000\u00db\u00c3"+
		"\u0001\u0000\u0000\u0000\u00db\u00c9\u0001\u0000\u0000\u0000\u00db\u00d9"+
		"\u0001\u0000\u0000\u0000\u00dc\u0115\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\n\r\u0000\u0000\u00de\u00df\u0007\b\u0000\u0000\u00df\u0114\u0003\u0014"+
		"\n\u000e\u00e0\u00e1\n\f\u0000\u0000\u00e1\u00e2\u0007\t\u0000\u0000\u00e2"+
		"\u0114\u0003\u0014\n\r\u00e3\u00e4\n\u000b\u0000\u0000\u00e4\u00e5\u0007"+
		"\n\u0000\u0000\u00e5\u0114\u0003\u0014\n\f\u00e6\u00e7\n\n\u0000\u0000"+
		"\u00e7\u00e8\u0007\u000b\u0000\u0000\u00e8\u0114\u0003\u0014\n\u000b\u00e9"+
		"\u00ea\n\t\u0000\u0000\u00ea\u00eb\u0007\f\u0000\u0000\u00eb\u0114\u0003"+
		"\u0014\n\n\u00ec\u00ed\n\b\u0000\u0000\u00ed\u00ee\u0005\u0101\u0000\u0000"+
		"\u00ee\u0114\u0003\u0014\n\t\u00ef\u00f0\n\u0007\u0000\u0000\u00f0\u00f1"+
		"\u0005\u0103\u0000\u0000\u00f1\u0114\u0003\u0014\n\b\u00f2\u00f3\n\u0006"+
		"\u0000\u0000\u00f3\u00f4\u0005\u0102\u0000\u0000\u00f4\u0114\u0003\u0014"+
		"\n\u0007\u00f5\u00f6\n\u0005\u0000\u0000\u00f6\u00f7\u0005\u00e2\u0000"+
		"\u0000\u00f7\u0114\u0003\u0014\n\u0006\u00f8\u00f9\n\u0004\u0000\u0000"+
		"\u00f9\u00fa\u0005\u00e3\u0000\u0000\u00fa\u0114\u0003\u0014\n\u0005\u00fb"+
		"\u00fc\n\u0003\u0000\u0000\u00fc\u00fd\u0005\u00e4\u0000\u0000\u00fd\u0114"+
		"\u0003\u0014\n\u0004\u00fe\u00ff\n\u0002\u0000\u0000\u00ff\u0100\u0005"+
		"\u0104\u0000\u0000\u0100\u0101\u0003\u0014\n\u0000\u0101\u0102\u0005\u0001"+
		"\u0000\u0000\u0102\u0103\u0003\u0014\n\u0002\u0103\u0114\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\n\u0001\u0000\u0000\u0105\u0106\u0007\r\u0000\u0000"+
		"\u0106\u0114\u0003\u0014\n\u0001\u0107\u0108\n\u0013\u0000\u0000\u0108"+
		"\u0109\u0005\u00f4\u0000\u0000\u0109\u010a\u0003\u0016\u000b\u0000\u010a"+
		"\u010b\u0005\u00f5\u0000\u0000\u010b\u0114\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\n\u0012\u0000\u0000\u010d\u0114\u0005\u0016\u0000\u0000\u010e\u010f"+
		"\n\u0010\u0000\u0000\u010f\u0110\u0005\u00f7\u0000\u0000\u0110\u0114\u0005"+
		"\u010a\u0000\u0000\u0111\u0112\n\u000f\u0000\u0000\u0112\u0114\u0007\u000e"+
		"\u0000\u0000\u0113\u00dd\u0001\u0000\u0000\u0000\u0113\u00e0\u0001\u0000"+
		"\u0000\u0000\u0113\u00e3\u0001\u0000\u0000\u0000\u0113\u00e6\u0001\u0000"+
		"\u0000\u0000\u0113\u00e9\u0001\u0000\u0000\u0000\u0113\u00ec\u0001\u0000"+
		"\u0000\u0000\u0113\u00ef\u0001\u0000\u0000\u0000\u0113\u00f2\u0001\u0000"+
		"\u0000\u0000\u0113\u00f5\u0001\u0000\u0000\u0000\u0113\u00f8\u0001\u0000"+
		"\u0000\u0000\u0113\u00fb\u0001\u0000\u0000\u0000\u0113\u00fe\u0001\u0000"+
		"\u0000\u0000\u0113\u0104\u0001\u0000\u0000\u0000\u0113\u0107\u0001\u0000"+
		"\u0000\u0000\u0113\u010c\u0001\u0000\u0000\u0000\u0113\u010e\u0001\u0000"+
		"\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000"+
		"\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000"+
		"\u0000\u0000\u0116\u0015\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000"+
		"\u0000\u0000\u0118\u011d\u0003\u0014\n\u0000\u0119\u011a\u0005\u00f6\u0000"+
		"\u0000\u011a\u011c\u0003\u0014\n\u0000\u011b\u0119\u0001\u0000\u0000\u0000"+
		"\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000"+
		"\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u0017\u0001\u0000\u0000\u0000"+
		"\u011f\u011d\u0001\u0000\u0000\u0000\u0120\u0121\u0003\u001a\r\u0000\u0121"+
		"\u0122\u0005\u00f3\u0000\u0000\u0122\u014e\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u00036\u001b\u0000\u0124\u0125\u0005\u010a\u0000\u0000\u0125\u012a"+
		"\u0003D\"\u0000\u0126\u0128\u0005\u010a\u0000\u0000\u0127\u0129\u0003"+
		":\u001d\u0000\u0128\u0127\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000"+
		"\u0000\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a\u0126\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0005\u00f3\u0000\u0000\u012d\u014e\u0001\u0000"+
		"\u0000\u0000\u012e\u0137\u00036\u001b\u0000\u012f\u0134\u0005\u010a\u0000"+
		"\u0000\u0130\u0131\u0005\u00f6\u0000\u0000\u0131\u0133\u0005\u010a\u0000"+
		"\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0133\u0136\u0001\u0000\u0000"+
		"\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000"+
		"\u0000\u0135\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000"+
		"\u0000\u0137\u012f\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000"+
		"\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013a\u0005\u00f3\u0000"+
		"\u0000\u013a\u014e\u0001\u0000\u0000\u0000\u013b\u013c\u0005\n\u0000\u0000"+
		"\u013c\u013d\u0003.\u0017\u0000\u013d\u013e\u00038\u001c\u0000\u013e\u013f"+
		"\u0005\u00f3\u0000\u0000\u013f\u014e\u0001\u0000\u0000\u0000\u0140\u0149"+
		"\u0003&\u0013\u0000\u0141\u0146\u0003$\u0012\u0000\u0142\u0143\u0005\u00f6"+
		"\u0000\u0000\u0143\u0145\u0003$\u0012\u0000\u0144\u0142\u0001\u0000\u0000"+
		"\u0000\u0145\u0148\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u014a\u0001\u0000\u0000"+
		"\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0149\u0141\u0001\u0000\u0000"+
		"\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000"+
		"\u0000\u014b\u014c\u0005\u00f3\u0000\u0000\u014c\u014e\u0001\u0000\u0000"+
		"\u0000\u014d\u0120\u0001\u0000\u0000\u0000\u014d\u0123\u0001\u0000\u0000"+
		"\u0000\u014d\u012e\u0001\u0000\u0000\u0000\u014d\u013b\u0001\u0000\u0000"+
		"\u0000\u014d\u0140\u0001\u0000\u0000\u0000\u014e\u0019\u0001\u0000\u0000"+
		"\u0000\u014f\u0151\u0003 \u0010\u0000\u0150\u014f\u0001\u0000\u0000\u0000"+
		"\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000"+
		"\u0152\u0153\u0003&\u0013\u0000\u0153\u0154\u0005\u010a\u0000\u0000\u0154"+
		"\u0155\u0005\u00ef\u0000\u0000\u0155\u0156\u0003\u001c\u000e\u0000\u0156"+
		"\u0158\u0005\u00f0\u0000\u0000\u0157\u0159\u0003 \u0010\u0000\u0158\u0157"+
		"\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u001b"+
		"\u0001\u0000\u0000\u0000\u015a\u015f\u0003\u001e\u000f\u0000\u015b\u015c"+
		"\u0005\u00f6\u0000\u0000\u015c\u015e\u0003\u001e\u000f\u0000\u015d\u015b"+
		"\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000\u0000\u0000\u015f\u015d"+
		"\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0163"+
		"\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u015a"+
		"\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000\u0000\u0000\u0163\u001d"+
		"\u0001\u0000\u0000\u0000\u0164\u0169\u0003&\u0013\u0000\u0165\u0167\u0005"+
		"\u010a\u0000\u0000\u0166\u0168\u0003:\u001d\u0000\u0167\u0166\u0001\u0000"+
		"\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u016a\u0001\u0000"+
		"\u0000\u0000\u0169\u0165\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000"+
		"\u0000\u0000\u016a\u001f\u0001\u0000\u0000\u0000\u016b\u016c\u0005\u00f4"+
		"\u0000\u0000\u016c\u016d\u0005\u00f4\u0000\u0000\u016d\u0172\u0003\"\u0011"+
		"\u0000\u016e\u016f\u0005\u00f6\u0000\u0000\u016f\u0171\u0003\"\u0011\u0000"+
		"\u0170\u016e\u0001\u0000\u0000\u0000\u0171\u0174\u0001\u0000\u0000\u0000"+
		"\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000"+
		"\u0173\u0175\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000"+
		"\u0175\u0176\u0005\u00f5\u0000\u0000\u0176\u0177\u0005\u00f5\u0000\u0000"+
		"\u0177!\u0001\u0000\u0000\u0000\u0178\u0179\u0005\u010a\u0000\u0000\u0179"+
		"\u017a\u0005\u0001\u0000\u0000\u017a\u017c\u0005\u0001\u0000\u0000\u017b"+
		"\u0178\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c"+
		"\u017d\u0001\u0000\u0000\u0000\u017d\u0182\u0005\u010a\u0000\u0000\u017e"+
		"\u017f\u0005\u00ef\u0000\u0000\u017f\u0180\u0003\u0016\u000b\u0000\u0180"+
		"\u0181\u0005\u00f0\u0000\u0000\u0181\u0183\u0001\u0000\u0000\u0000\u0182"+
		"\u017e\u0001\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183"+
		"#\u0001\u0000\u0000\u0000\u0184\u0186\u0005\u010a\u0000\u0000\u0185\u0187"+
		"\u0003:\u001d\u0000\u0186\u0185\u0001\u0000\u0000\u0000\u0186\u0187\u0001"+
		"\u0000\u0000\u0000\u0187\u018a\u0001\u0000\u0000\u0000\u0188\u0189\u0005"+
		"\u0105\u0000\u0000\u0189\u018b\u0003J%\u0000\u018a\u0188\u0001\u0000\u0000"+
		"\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b%\u0001\u0000\u0000\u0000"+
		"\u018c\u018e\u00036\u001b\u0000\u018d\u018c\u0001\u0000\u0000\u0000\u018d"+
		"\u018e\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018f"+
		"\u0190\u00038\u001c\u0000\u0190\'\u0001\u0000\u0000\u0000\u0191\u01ba"+
		"\u0005\u000b\u0000\u0000\u0192\u01ba\u0005\u0004\u0000\u0000\u0193\u01ba"+
		"\u0005\u0005\u0000\u0000\u0194\u01ba\u0005\u0006\u0000\u0000\u0195\u01ba"+
		"\u0005\u0010\u0000\u0000\u0196\u01ba\u0005\u0019\u0000\u0000\u0197\u01ba"+
		"\u0005\u0018\u0000\u0000\u0198\u01ba\u0005\u0002\u0000\u0000\u0199\u01ba"+
		"\u0005\u0013\u0000\u0000\u019a\u01ba\u0005\u0011\u0000\u0000\u019b\u01ba"+
		"\u0005\u0003\u0000\u0000\u019c\u01ba\u0005\u0014\u0000\u0000\u019d\u01ba"+
		"\u0005\u001b\u0000\u0000\u019e\u01ba\u0005\u0012\u0000\u0000\u019f\u01ba"+
		"\u0005\u001a\u0000\u0000\u01a0\u01ba\u0005\u001c\u0000\u0000\u01a1\u01ba"+
		"\u0005\u001d\u0000\u0000\u01a2\u01ad\u0005\u001e\u0000\u0000\u01a3\u01a4"+
		"\u0005\u00ef\u0000\u0000\u01a4\u01a9\u0005\u010a\u0000\u0000\u01a5\u01a6"+
		"\u0005\u00f6\u0000\u0000\u01a6\u01a8\u0005\u010a\u0000\u0000\u01a7\u01a5"+
		"\u0001\u0000\u0000\u0000\u01a8\u01ab\u0001\u0000\u0000\u0000\u01a9\u01a7"+
		"\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01ac"+
		"\u0001\u0000\u0000\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000\u01ac\u01ae"+
		"\u0005\u00f0\u0000\u0000\u01ad\u01a3\u0001\u0000\u0000\u0000\u01ad\u01ae"+
		"\u0001\u0000\u0000\u0000\u01ae\u01ba\u0001\u0000\u0000\u0000\u01af\u01ba"+
		"\u0005\u001f\u0000\u0000\u01b0\u01ba\u0005 \u0000\u0000\u01b1\u01ba\u0005"+
		"!\u0000\u0000\u01b2\u01ba\u0005\"\u0000\u0000\u01b3\u01ba\u0005#\u0000"+
		"\u0000\u01b4\u01ba\u0005$\u0000\u0000\u01b5\u01ba\u0005%\u0000\u0000\u01b6"+
		"\u01ba\u0005&\u0000\u0000\u01b7\u01ba\u0005\'\u0000\u0000\u01b8\u01ba"+
		"\u0005(\u0000\u0000\u01b9\u0191\u0001\u0000\u0000\u0000\u01b9\u0192\u0001"+
		"\u0000\u0000\u0000\u01b9\u0193\u0001\u0000\u0000\u0000\u01b9\u0194\u0001"+
		"\u0000\u0000\u0000\u01b9\u0195\u0001\u0000\u0000\u0000\u01b9\u0196\u0001"+
		"\u0000\u0000\u0000\u01b9\u0197\u0001\u0000\u0000\u0000\u01b9\u0198\u0001"+
		"\u0000\u0000\u0000\u01b9\u0199\u0001\u0000\u0000\u0000\u01b9\u019a\u0001"+
		"\u0000\u0000\u0000\u01b9\u019b\u0001\u0000\u0000\u0000\u01b9\u019c\u0001"+
		"\u0000\u0000\u0000\u01b9\u019d\u0001\u0000\u0000\u0000\u01b9\u019e\u0001"+
		"\u0000\u0000\u0000\u01b9\u019f\u0001\u0000\u0000\u0000\u01b9\u01a0\u0001"+
		"\u0000\u0000\u0000\u01b9\u01a1\u0001\u0000\u0000\u0000\u01b9\u01a2\u0001"+
		"\u0000\u0000\u0000\u01b9\u01af\u0001\u0000\u0000\u0000\u01b9\u01b0\u0001"+
		"\u0000\u0000\u0000\u01b9\u01b1\u0001\u0000\u0000\u0000\u01b9\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b9\u01b3\u0001\u0000\u0000\u0000\u01b9\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b9\u01b5\u0001\u0000\u0000\u0000\u01b9\u01b6\u0001"+
		"\u0000\u0000\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000\u01b9\u01b8\u0001"+
		"\u0000\u0000\u0000\u01ba)\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005\u0015"+
		"\u0000\u0000\u01bc\u01bd\u0005\u00ef\u0000\u0000\u01bd\u01c2\u0003,\u0016"+
		"\u0000\u01be\u01bf\u0005\u00f6\u0000\u0000\u01bf\u01c1\u0003,\u0016\u0000"+
		"\u01c0\u01be\u0001\u0000\u0000\u0000\u01c1\u01c4\u0001\u0000\u0000\u0000"+
		"\u01c2\u01c0\u0001\u0000\u0000\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000"+
		"\u01c3\u01c5\u0001\u0000\u0000\u0000\u01c4\u01c2\u0001\u0000\u0000\u0000"+
		"\u01c5\u01c6\u0005\u00f0\u0000\u0000\u01c6+\u0001\u0000\u0000\u0000\u01c7"+
		"\u01ca\u0005\u010a\u0000\u0000\u01c8\u01c9\u0005\u0105\u0000\u0000\u01c9"+
		"\u01cb\u0003\u0016\u000b\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01ca"+
		"\u01cb\u0001\u0000\u0000\u0000\u01cb\u01ce\u0001\u0000\u0000\u0000\u01cc"+
		"\u01ce\u0005\u0014\u0000\u0000\u01cd\u01c7\u0001\u0000\u0000\u0000\u01cd"+
		"\u01cc\u0001\u0000\u0000\u0000\u01ce-\u0001\u0000\u0000\u0000\u01cf\u01d0"+
		"\u0007\u000f\u0000\u0000\u01d0/\u0001\u0000\u0000\u0000\u01d1\u01d2\u0007"+
		"\u0010\u0000\u0000\u01d21\u0001\u0000\u0000\u0000\u01d3\u01d4\u0005\r"+
		"\u0000\u0000\u01d43\u0001\u0000\u0000\u0000\u01d5\u01d6\u0005\f\u0000"+
		"\u0000\u01d65\u0001\u0000\u0000\u0000\u01d7\u01de\u0003(\u0014\u0000\u01d8"+
		"\u01de\u0003*\u0015\u0000\u01d9\u01de\u0003.\u0017\u0000\u01da\u01de\u0003"+
		"0\u0018\u0000\u01db\u01de\u00032\u0019\u0000\u01dc\u01de\u00034\u001a"+
		"\u0000\u01dd\u01d7\u0001\u0000\u0000\u0000\u01dd\u01d8\u0001\u0000\u0000"+
		"\u0000\u01dd\u01d9\u0001\u0000\u0000\u0000\u01dd\u01da\u0001\u0000\u0000"+
		"\u0000\u01dd\u01db\u0001\u0000\u0000\u0000\u01dd\u01dc\u0001\u0000\u0000"+
		"\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01df\u01dd\u0001\u0000\u0000"+
		"\u0000\u01df\u01e0\u0001\u0000\u0000\u0000\u01e07\u0001\u0000\u0000\u0000"+
		"\u01e1\u01e6\u0005\u010a\u0000\u0000\u01e2\u01e6\u0003@ \u0000\u01e3\u01e6"+
		"\u0003>\u001f\u0000\u01e4\u01e6\u0003B!\u0000\u01e5\u01e1\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e2\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e4\u0001\u0000\u0000\u0000\u01e6\u01e8\u0001\u0000"+
		"\u0000\u0000\u01e7\u01e9\u0003:\u001d\u0000\u01e8\u01e7\u0001\u0000\u0000"+
		"\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e99\u0001\u0000\u0000\u0000"+
		"\u01ea\u01ec\u0003<\u001e\u0000\u01eb\u01ea\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ed\u0001\u0000\u0000\u0000\u01ed\u01eb\u0001\u0000\u0000\u0000\u01ed"+
		"\u01ee\u0001\u0000\u0000\u0000\u01ee;\u0001\u0000\u0000\u0000\u01ef\u01f1"+
		"\u0005\u00f4\u0000\u0000\u01f0\u01f2\u0003\u0016\u000b\u0000\u01f1\u01f0"+
		"\u0001\u0000\u0000\u0000\u01f1\u01f2\u0001\u0000\u0000\u0000\u01f2\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f3\u01f4\u0005\u00f5\u0000\u0000\u01f4=\u0001"+
		"\u0000\u0000\u0000\u01f5\u01f6\u0007\u0011\u0000\u0000\u01f6?\u0001\u0000"+
		"\u0000\u0000\u01f7\u01f8\u0007\u0012\u0000\u0000\u01f8A\u0001\u0000\u0000"+
		"\u0000\u01f9\u01fb\u0005-\u0000\u0000\u01fa\u01fc\u0005\u010a\u0000\u0000"+
		"\u01fb\u01fa\u0001\u0000\u0000\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000"+
		"\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd\u01fe\u0003D\"\u0000\u01fe"+
		"C\u0001\u0000\u0000\u0000\u01ff\u0201\u0005\u00f1\u0000\u0000\u0200\u0202"+
		"\u0003F#\u0000\u0201\u0200\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000"+
		"\u0000\u0000\u0203\u0201\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000"+
		"\u0000\u0000\u0204\u0205\u0001\u0000\u0000\u0000\u0205\u0206\u0005\u00f2"+
		"\u0000\u0000\u0206E\u0001\u0000\u0000\u0000\u0207\u0208\u0003&\u0013\u0000"+
		"\u0208\u020d\u0003H$\u0000\u0209\u020a\u0005\u00f6\u0000\u0000\u020a\u020c"+
		"\u0003H$\u0000\u020b\u0209\u0001\u0000\u0000\u0000\u020c\u020f\u0001\u0000"+
		"\u0000\u0000\u020d\u020b\u0001\u0000\u0000\u0000\u020d\u020e\u0001\u0000"+
		"\u0000\u0000\u020e\u0210\u0001\u0000\u0000\u0000\u020f\u020d\u0001\u0000"+
		"\u0000\u0000\u0210\u0211\u0005\u00f3\u0000\u0000\u0211G\u0001\u0000\u0000"+
		"\u0000\u0212\u0214\u0005\u010a\u0000\u0000\u0213\u0215\u0003:\u001d\u0000"+
		"\u0214\u0213\u0001\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000\u0000"+
		"\u0215I\u0001\u0000\u0000\u0000\u0216\u0227\u0003\u0014\n\u0000\u0217"+
		"\u0223\u0005\u00f1\u0000\u0000\u0218\u021d\u0003J%\u0000\u0219\u021a\u0005"+
		"\u00f6\u0000\u0000\u021a\u021c\u0003J%\u0000\u021b\u0219\u0001\u0000\u0000"+
		"\u0000\u021c\u021f\u0001\u0000\u0000\u0000\u021d\u021b\u0001\u0000\u0000"+
		"\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021e\u0221\u0001\u0000\u0000"+
		"\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u0220\u0222\u0005\u00f6\u0000"+
		"\u0000\u0221\u0220\u0001\u0000\u0000\u0000\u0221\u0222\u0001\u0000\u0000"+
		"\u0000\u0222\u0224\u0001\u0000\u0000\u0000\u0223\u0218\u0001\u0000\u0000"+
		"\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0224\u0225\u0001\u0000\u0000"+
		"\u0000\u0225\u0227\u0005\u00f2\u0000\u0000\u0226\u0216\u0001\u0000\u0000"+
		"\u0000\u0226\u0217\u0001\u0000\u0000\u0000\u0227K\u0001\u0000\u0000\u0000"+
		"\u0228\u0235\u0003N\'\u0000\u0229\u0235\u0003P(\u0000\u022a\u0235\u0003"+
		"R)\u0000\u022b\u0235\u0003T*\u0000\u022c\u0235\u0003V+\u0000\u022d\u0235"+
		"\u0003Z-\u0000\u022e\u0235\u0003\\.\u0000\u022f\u0235\u0003b1\u0000\u0230"+
		"\u0235\u0003^/\u0000\u0231\u0235\u0003`0\u0000\u0232\u0235\u0003d2\u0000"+
		"\u0233\u0235\u0003f3\u0000\u0234\u0228\u0001\u0000\u0000\u0000\u0234\u0229"+
		"\u0001\u0000\u0000\u0000\u0234\u022a\u0001\u0000\u0000\u0000\u0234\u022b"+
		"\u0001\u0000\u0000\u0000\u0234\u022c\u0001\u0000\u0000\u0000\u0234\u022d"+
		"\u0001\u0000\u0000\u0000\u0234\u022e\u0001\u0000\u0000\u0000\u0234\u022f"+
		"\u0001\u0000\u0000\u0000\u0234\u0230\u0001\u0000\u0000\u0000\u0234\u0231"+
		"\u0001\u0000\u0000\u0000\u0234\u0232\u0001\u0000\u0000\u0000\u0234\u0233"+
		"\u0001\u0000\u0000\u0000\u0235M\u0001\u0000\u0000\u0000\u0236\u023a\u0005"+
		"\u00f1\u0000\u0000\u0237\u0239\u0003L&\u0000\u0238\u0237\u0001\u0000\u0000"+
		"\u0000\u0239\u023c\u0001\u0000\u0000\u0000\u023a\u0238\u0001\u0000\u0000"+
		"\u0000\u023a\u023b\u0001\u0000\u0000\u0000\u023b\u023d\u0001\u0000\u0000"+
		"\u0000\u023c\u023a\u0001\u0000\u0000\u0000\u023d\u023e\u0005\u00f2\u0000"+
		"\u0000\u023eO\u0001\u0000\u0000\u0000\u023f\u0240\u0003\u0018\f\u0000"+
		"\u0240Q\u0001\u0000\u0000\u0000\u0241\u0242\u0003\u0016\u000b\u0000\u0242"+
		"\u0243\u0005\u00f3\u0000\u0000\u0243S\u0001\u0000\u0000\u0000\u0244\u0245"+
		"\u0005\u00f3\u0000\u0000\u0245U\u0001\u0000\u0000\u0000\u0246\u0248\u0003"+
		" \u0010\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u0247\u0248\u0001\u0000"+
		"\u0000\u0000\u0248\u0249\u0001\u0000\u0000\u0000\u0249\u024a\u0005.\u0000"+
		"\u0000\u024a\u024b\u0005\u00ef\u0000\u0000\u024b\u024c\u0003\u0016\u000b"+
		"\u0000\u024c\u024d\u0005\u00f0\u0000\u0000\u024d\u0250\u0003L&\u0000\u024e"+
		"\u024f\u0005/\u0000\u0000\u024f\u0251\u0003L&\u0000\u0250\u024e\u0001"+
		"\u0000\u0000\u0000\u0250\u0251\u0001\u0000\u0000\u0000\u0251W\u0001\u0000"+
		"\u0000\u0000\u0252\u0253\u0003&\u0013\u0000\u0253\u0254\u0005\u010a\u0000"+
		"\u0000\u0254\u0255\u0005\u0105\u0000\u0000\u0255\u0256\u0003J%\u0000\u0256"+
		"Y\u0001\u0000\u0000\u0000\u0257\u0259\u0003 \u0010\u0000\u0258\u0257\u0001"+
		"\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u025a\u0001"+
		"\u0000\u0000\u0000\u025a\u025b\u00050\u0000\u0000\u025b\u025c\u0005\u00ef"+
		"\u0000\u0000\u025c\u025d\u0003\u0016\u000b\u0000\u025d\u025e\u0005\u00f0"+
		"\u0000\u0000\u025e\u025f\u0003N\'\u0000\u025f[\u0001\u0000\u0000\u0000"+
		"\u0260\u0261\u00051\u0000\u0000\u0261\u0262\u0003\u0016\u000b\u0000\u0262"+
		"\u0263\u0005\u0001\u0000\u0000\u0263\u0267\u0001\u0000\u0000\u0000\u0264"+
		"\u0265\u00052\u0000\u0000\u0265\u0267\u0005\u0001\u0000\u0000\u0266\u0260"+
		"\u0001\u0000\u0000\u0000\u0266\u0264\u0001\u0000\u0000\u0000\u0267]\u0001"+
		"\u0000\u0000\u0000\u0268\u026a\u0003 \u0010\u0000\u0269\u0268\u0001\u0000"+
		"\u0000\u0000\u0269\u026a\u0001\u0000\u0000\u0000\u026a\u026b\u0001\u0000"+
		"\u0000\u0000\u026b\u026c\u00053\u0000\u0000\u026c\u026f\u0005\u00ef\u0000"+
		"\u0000\u026d\u0270\u0003\u0016\u000b\u0000\u026e\u0270\u0003X,\u0000\u026f"+
		"\u026d\u0001\u0000\u0000\u0000\u026f\u026e\u0001\u0000\u0000\u0000\u0270"+
		"\u0271\u0001\u0000\u0000\u0000\u0271\u0272\u0005\u00f0\u0000\u0000\u0272"+
		"\u0273\u0003L&\u0000\u0273_\u0001\u0000\u0000\u0000\u0274\u0276\u0003"+
		" \u0010\u0000\u0275\u0274\u0001\u0000\u0000\u0000\u0275\u0276\u0001\u0000"+
		"\u0000\u0000\u0276\u0277\u0001\u0000\u0000\u0000\u0277\u0278\u00054\u0000"+
		"\u0000\u0278\u0279\u0003L&\u0000\u0279\u027a\u00053\u0000\u0000\u027a"+
		"\u027b\u0005\u00ef\u0000\u0000\u027b\u027c\u0003\u0016\u000b\u0000\u027c"+
		"\u027d\u0005\u00f0\u0000\u0000\u027d\u027e\u0005\u00f3\u0000\u0000\u027e"+
		"a\u0001\u0000\u0000\u0000\u027f\u0281\u0003 \u0010\u0000\u0280\u027f\u0001"+
		"\u0000\u0000\u0000\u0280\u0281\u0001\u0000\u0000\u0000\u0281\u0282\u0001"+
		"\u0000\u0000\u0000\u0282\u0283\u00055\u0000\u0000\u0283\u0287\u0005\u00ef"+
		"\u0000\u0000\u0284\u0288\u0003T*\u0000\u0285\u0288\u0003R)\u0000\u0286"+
		"\u0288\u0003P(\u0000\u0287\u0284\u0001\u0000\u0000\u0000\u0287\u0285\u0001"+
		"\u0000\u0000\u0000\u0287\u0286\u0001\u0000\u0000\u0000\u0288\u028b\u0001"+
		"\u0000\u0000\u0000\u0289\u028c\u0003\u0016\u000b\u0000\u028a\u028c\u0003"+
		"X,\u0000\u028b\u0289\u0001\u0000\u0000\u0000\u028b\u028a\u0001\u0000\u0000"+
		"\u0000\u028b\u028c\u0001\u0000\u0000\u0000\u028c\u028d\u0001\u0000\u0000"+
		"\u0000\u028d\u028f\u0005\u00f3\u0000\u0000\u028e\u0290\u0003\u0016\u000b"+
		"\u0000\u028f\u028e\u0001\u0000\u0000\u0000\u028f\u0290\u0001\u0000\u0000"+
		"\u0000\u0290\u0291\u0001\u0000\u0000\u0000\u0291\u0292\u0005\u00f0\u0000"+
		"\u0000\u0292\u0293\u0003L&\u0000\u0293c\u0001\u0000\u0000\u0000\u0294"+
		"\u0295\u00056\u0000\u0000\u0295\u02a4\u0005\u00f3\u0000\u0000\u0296\u0297"+
		"\u00057\u0000\u0000\u0297\u02a4\u0005\u00f3\u0000\u0000\u0298\u029a\u0005"+
		"8\u0000\u0000\u0299\u029b\u0003\u0016\u000b\u0000\u029a\u0299\u0001\u0000"+
		"\u0000\u0000\u029a\u029b\u0001\u0000\u0000\u0000\u029b\u029c\u0001\u0000"+
		"\u0000\u0000\u029c\u02a4\u0005\u00f3\u0000\u0000\u029d\u029e\u00059\u0000"+
		"\u0000\u029e\u02a4\u0005\u00f3\u0000\u0000\u029f\u02a0\u0005)\u0000\u0000"+
		"\u02a0\u02a4\u0005\u00f3\u0000\u0000\u02a1\u02a2\u0005*\u0000\u0000\u02a2"+
		"\u02a4\u0005\u00f3\u0000\u0000\u02a3\u0294\u0001\u0000\u0000\u0000\u02a3"+
		"\u0296\u0001\u0000\u0000\u0000\u02a3\u0298\u0001\u0000\u0000\u0000\u02a3"+
		"\u029d\u0001\u0000\u0000\u0000\u02a3\u029f\u0001\u0000\u0000\u0000\u02a3"+
		"\u02a1\u0001\u0000\u0000\u0000\u02a4e\u0001\u0000\u0000\u0000\u02a5\u02a6"+
		"\u0005:\u0000\u0000\u02a6\u02a7\u0005\u00f3\u0000\u0000\u02a7g\u0001\u0000"+
		"\u0000\u0000Hinw\u0083\u008a\u0095\u009e\u00a5\u00ad\u00b2\u00b5\u00c9"+
		"\u00d3\u00d6\u00db\u0113\u0115\u011d\u0128\u012a\u0134\u0137\u0146\u0149"+
		"\u014d\u0150\u0158\u015f\u0162\u0167\u0169\u0172\u017b\u0182\u0186\u018a"+
		"\u018d\u01a9\u01ad\u01b9\u01c2\u01ca\u01cd\u01dd\u01df\u01e5\u01e8\u01ed"+
		"\u01f1\u01fb\u0203\u020d\u0214\u021d\u0221\u0223\u0226\u0234\u023a\u0247"+
		"\u0250\u0258\u0266\u0269\u026f\u0275\u0280\u0287\u028b\u028f\u029a\u02a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
