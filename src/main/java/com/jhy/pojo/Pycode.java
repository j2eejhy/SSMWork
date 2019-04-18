package com.jhy.pojo;

public class Pycode {
    private Long id;

    private String name;

    private String codea;

    private String codeb;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCodea() {
        return codea;
    }

    public void setCodea(String codea) {
        this.codea = codea == null ? null : codea.trim();
    }

    public String getCodeb() {
        return codeb;
    }

    public void setCodeb(String codeb) {
        this.codeb = codeb == null ? null : codeb.trim();
    }
}