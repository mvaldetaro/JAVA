package br.com.infnet.model;

import java.sql.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T08:51:23")
@StaticMetamodel(Sessoes.class)
public class Sessoes_ { 

    public static volatile SingularAttribute<Sessoes, String> preco;
    public static volatile SingularAttribute<Sessoes, Date> data;
    public static volatile SingularAttribute<Sessoes, Time> horario;
    public static volatile SingularAttribute<Sessoes, Integer> idsessao;
    public static volatile SingularAttribute<Sessoes, String> titulo;
    public static volatile SingularAttribute<Sessoes, String> nome;
    public static volatile SingularAttribute<Sessoes, Integer> idsala;

}