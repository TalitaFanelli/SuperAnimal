package bd;

import bd.core.*;
import bd.daos.*;

public class BD
{
    public static final MeuPreparedStatement comando;
    public static final Medicos medicos; //um como esse para cada classe DAO
    public static final Clientes clientes; //um como esse para cada classe DAO
    public static final Animais animais; //um como esse para cada classe DAO
    public static final Agendamentos agendamentos; //um como esse para cada classe DAO

    static
    {
    	MeuPreparedStatement _comando = null;
     	Medicos              _medicos  = null; //um como esse para cada classe DAO
     	Clientes              _clientes  = null; //um como esse para cada classe DAO
     	Animais              _animais  = null; //um como esse para cada classe DAO
     	Agendamentos         _agendamentos  = null; //um como esse para cada classe DAO

    	try
        {
            /*  _comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://fs5:1433;databasename=bdac2017226",
            "bdac2017226", "Fhjla9");*/
 
    		 _comando =
    		            new MeuPreparedStatement (
    				"com.mysql.jdbc.Driver",
    				"jdbc:mysql://localhost:3306/web",
    				"root", "root");

            _medicos = new Medicos (); //um como esse para cada classe DAO
            _clientes = new Clientes (); //um como esse para cada classe DAO
            _animais = new Animais (); //um como esse para cada classe DAO
            _agendamentos = new Agendamentos (); //um como esse para cada classe DAO
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
        
        comando = _comando;
        medicos  = _medicos; //um como esse para cada classe DAO
        clientes  = _clientes; //um como esse para cada classe DAO
        animais  = _animais; //um como esse para cada classe DAO
        agendamentos  = _agendamentos; //um como esse para cada classe DAO
    }
}