/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.dao;

import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Odpoved;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface OdpovedDao {
    Odpoved findById(int id);
    Odpoved findByUzivatelDotaznik(int uzivatel_id,int dotaznik_id);
    void save(Odpoved odpoved);
    void delete(Odpoved odpoved);
    List<Odpoved> findAll();
    Odpoved findByText(String Text);
    
}
