package es.cuatrogatos.cmd;

import org.apache.commons.cli.*;

public class CmdParser {
    public final static String SOLAXAPI_URL="surl";
    public final static String SOLAXAPI_URL_GNU="solax-url";
    public final static String SOLAXAPI_TOKEN="token";
    public final static String SOLAXAPI_TOKEN_GNU="token-id";
    public final static String SOLAXAPI_SN="sn";
    public final static String SOLAXAPI_SN_GNU="solax-serial-number";


    public final static String GRAFANA_SERVICE_URL="gurl";



    private static String apiUrl;
    private static String token;
    private static String serialNumber;

    private static String wolServiceUser;
    private static String wolServicePasswd;
    private static String wolServicePort;

    private static String wolBindingIp;
    private static String wolBindingPort;


    public static void parse(String args[]) throws ParseException {
        Options options=new Options();
        CommandLineParser parser = new DefaultParser();

        options.addRequiredOption(SOLAXAPI_URL,SOLAXAPI_URL_GNU,true,"Solax cloud api endpoint. Ej: https://www.solaxcloud.com:9443/proxy/api/getRealtimeInfo.do");
        options.addRequiredOption(SOLAXAPI_TOKEN,SOLAXAPI_TOKEN_GNU,true,"Token del api de solax cloud");
        options.addRequiredOption(SOLAXAPI_SN,SOLAXAPI_SN_GNU,true,"Solax Serial Number ");


        CommandLine line = parser.parse( options, args );
        processSolaxOptions(line);

    }

    public static String getApiUrl() {
        return apiUrl;
    }

    public static void setApiUrl(String apiUrl) {
        CmdParser.apiUrl = apiUrl;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        CmdParser.token = token;
    }

    public static String getSerialNumber() {
        return serialNumber;
    }

    public static void setSerialNumber(String serialNumber) {
        CmdParser.serialNumber = serialNumber;
    }


    private static void processSolaxOptions(CommandLine line){
        if(line.hasOption(SOLAXAPI_URL)){
            apiUrl=line.getOptionValue(SOLAXAPI_URL);
        }

        if(line.hasOption(SOLAXAPI_TOKEN)){
            token=line.getOptionValue(SOLAXAPI_TOKEN);
        }

        if(line.hasOption(SOLAXAPI_SN)){
            serialNumber=line.getOptionValue(SOLAXAPI_SN);
        }
    }


    private static void printHelp(Options options){
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("          |\n" +
                "        \\ _ /\n" +
                "      -= (_) =-\n" +
                "        /   \\         _\\/_\n" +
                "          |           //o\\  _\\/_\n" +
                "   _____ _ __ __ ____ _ | __/o\\\\ _\n" +
                " =-=-_-__=_-= _=_=-=_,-'|\"'\"\"-|-,_\n" +
                "  =- _=-=- -_=-=_,-\"          |\n" +
                "    =- =- -=.--\"\n"+
                " \n\n\t SOLAX CLOUD GRAFANA BYPASS\n", options);
        return ;
    }

    public static String getWolServiceUser() {
        return wolServiceUser;
    }

    public static void setWolServiceUser(String wolServiceUser) {
        CmdParser.wolServiceUser = wolServiceUser;
    }

    public static String getWolServicePasswd() {
        return wolServicePasswd;
    }

    public static void setWolServicePasswd(String wolServicePasswd) {
        CmdParser.wolServicePasswd = wolServicePasswd;
    }

    public static String getWolServicePort() {
        return wolServicePort;
    }

    public static void setWolServicePort(String wolServicePort) {
        CmdParser.wolServicePort = wolServicePort;
    }

    public static String getWolBindingIp() {
        return wolBindingIp;
    }

    public static void setWolBindingIp(String wolBindingIp) {
        CmdParser.wolBindingIp = wolBindingIp;
    }

    public static String getWolBindingPort() {
        if(wolBindingPort==null){
            return "9";
        }
        return wolBindingPort;
    }

    public static void setWolBindingPort(String wolBindingPort) {
        CmdParser.wolBindingPort = wolBindingPort;
    }
}
