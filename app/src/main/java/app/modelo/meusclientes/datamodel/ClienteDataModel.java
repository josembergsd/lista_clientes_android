package app.modelo.meusclientes.datamodel;

public class ClienteDataModel {
   //1 Criar atributo nome da tabela
    public static final String TABELA = "cliente";

    //2 Criar atributos da tabela
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String PHONENUMBER = "phoneNumber";
    public static final String ZIPCODE = "zip_code";
    public static final String PUBLICPLACES = "public_places";
    public static final String ADDRNUMBER = "numero";
    public static final String DISTRICTY = "districty";
    public static final String CITY = "city";
    public static final String STATE = "uf";
    public static final String USE_TERMS = "use_terms"; //integer 1 or 0

    //3 Criar Query de criação da tabela
    public static String queryCreatTable = "";

    //4 Método que cria Script para criar a tabela
    public static String createTable(){

        queryCreatTable += "CREATE TABLE " + TABELA + " (";
        queryCreatTable += ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCreatTable += NOME + " TEXT, ";
        queryCreatTable += EMAIL + " TEXT, ";
        queryCreatTable += PHONENUMBER + " TEXT, ";
        queryCreatTable += ZIPCODE + " TEXT, ";
        queryCreatTable += PUBLICPLACES + " TEXT, ";
        queryCreatTable += ADDRNUMBER + " TEXT, ";
        queryCreatTable += DISTRICTY + " TEXT, ";
        queryCreatTable += CITY + " TEXT, ";
        queryCreatTable += STATE + " TEXT, ";
        queryCreatTable += USE_TERMS + " INTEGER ";
        queryCreatTable += ")";

        return queryCreatTable;
    }
}
