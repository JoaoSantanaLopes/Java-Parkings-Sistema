package org.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.example.model.Vaga;
import org.example.model.VagaIdoso;
import org.example.model.VagaPCD;
import org.example.model.VagaVip;

public class VagaController {
    private int normal;
    private int idoso;
    private int PCD;
    private int VIP;

    public VagaController(int normal, int idoso, int PCD, int VIP) {
        this.normal = normal;
        this.idoso = idoso;
        this.PCD = PCD;
        this.VIP = VIP;
    }
    
    public Map<String, Vaga> GerarVagas(){
        Map<String, Vaga> map = new HashMap<String, Vaga>();
        ArrayList<Vaga> vagas = new ArrayList<>();
        vagas.addAll(GerarIdoso());
        vagas.addAll(GerarPcd());
        vagas.addAll(GerarVaga());
        vagas.addAll(GerarVip());
        for(Vaga vaga : vagas){
            map.put(vaga.getIdentificador(), vaga);
        }
        return map;
    }
    
    private ArrayList<VagaIdoso> GerarIdoso() {
        ArrayList<VagaIdoso> array = new ArrayList<>();
        for(int i = 0; i < idoso; i++){
            VagaIdoso obj = new VagaIdoso("VI", true);
            array.add(obj);
        }
        return array;
    }
    private ArrayList<VagaPCD> GerarPcd() {
        ArrayList<VagaPCD> array = new ArrayList<>();
        for(int i = 0; i < PCD; i++){
            VagaPCD obj = new VagaPCD("VPCD", true);
            array.add(obj);
        }
        return array;
    }
    private ArrayList<Vaga> GerarVaga() {
        ArrayList<Vaga> array = new ArrayList<>();
        for(int i = 0; i < normal; i++){
            Vaga obj = new Vaga("V", true);
            array.add(obj);
        }
        return array;
    }
    private ArrayList<VagaVip> GerarVip() {
        ArrayList<VagaVip> array = new ArrayList<>();
        for(int i = 0; i < VIP; i++){
            VagaVip obj = new VagaVip("VIP", true);
            array.add(obj);
        }
        return array;
    }
}
