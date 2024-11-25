package com.lucassilveira.receitario.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lucassilveira.receitario.model.Measure;
import com.lucassilveira.receitario.repository.MeasureRepository;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MeasureSeeder implements CommandLineRunner {

    @Autowired
    private MeasureRepository measureRepository;

    public void run(String...args) throws Exception {
        // Criar medidas
        Measure measure1 = new Measure();
        measure1.setId(1);
        measure1.setName("colher de sopa");
        measureRepository.save(measure1);

        Measure measure2 = new Measure();
        measure2.setId(2);
        measure2.setName("colher de chá");
        measureRepository.save(measure2);

        Measure measure3 = new Measure();
        measure3.setId(3);
        measure3.setName("xícara");
        measureRepository.save(measure3);

        Measure measure4 = new Measure();
        measure4.setId(4);
        measure4.setName("ml");
        measureRepository.save(measure4);

        Measure measure5 = new Measure();
        measure5.setId(5);
        measure5.setName("l");
        measureRepository.save(measure5);

        Measure measure6 = new Measure();
        measure6.setId(6);
        measure6.setName("g");
        measureRepository.save(measure6);

        Measure measure7 = new Measure();
        measure7.setId(7);
        measure7.setName("kg");
        measureRepository.save(measure7);

        Measure measure8 = new Measure();
        measure8.setId(8);
        measure8.setName("mg");
        measureRepository.save(measure8);

        Measure measure9 = new Measure();
        measure9.setId(9);
        measure9.setName("copo americano");
        measureRepository.save(measure9);

        Measure measure10 = new Measure();
        measure10.setId(10);
        measure10.setName("talo");
        measureRepository.save(measure10);

        Measure measure11 = new Measure();
        measure11.setId(11);
        measure11.setName("pitada");
        measureRepository.save(measure11);

        Measure measure12 = new Measure();
        measure12.setId(12);
        measure12.setName("xícara de chá");
        measureRepository.save(measure12);

        Measure measure13 = new Measure();
        measure13.setId(13);
        measure13.setName("a gosto");
        measureRepository.save(measure13);

        Measure measure14 = new Measure();
        measure14.setId(14);
        measure14.setName("unidade");
        measureRepository.save(measure14);
    }
}
