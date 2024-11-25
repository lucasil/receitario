package com.lucassilveira.receitario.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lucassilveira.receitario.model.DishCategory;
import com.lucassilveira.receitario.repository.DishCategoryRepository;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DishCategorySeeder implements CommandLineRunner {

    @Autowired
    private DishCategoryRepository dishCategoryRepository;

    @Override
    public void run(String...args) throws Exception {
        // Criar categorias
        DishCategory dishCategory1 = new DishCategory();
        dishCategory1.setId(1);
        dishCategory1.setName("Carne de Porco");
        dishCategory1.setDescription("Pratos que utilizam carne suína, como lombo, costela e bacon, em preparações que vão de assados a frituras.");
        dishCategoryRepository.save(dishCategory1);

        DishCategory dishCategory2 = new DishCategory();
        dishCategory2.setId(2);
        dishCategory2.setName("Carne Vermelha");
        dishCategory2.setDescription("Receitas que destacam cortes bovinos, ideais para grelhados, assados ou pratos como estrogonofe e carnes de panela.");
        dishCategoryRepository.save(dishCategory2);

        DishCategory dishCategory3 = new DishCategory();
        dishCategory3.setId(3);
        dishCategory3.setName("Doces");
        dishCategory3.setDescription("Delícias para adoçar o paladar, como bolos, tortas, pudins, doces e biscoitos.");
        dishCategoryRepository.save(dishCategory3);

        DishCategory dishCategory4 = new DishCategory();
        dishCategory4.setId(4);
        dishCategory4.setName("Massas");
        dishCategory4.setDescription("Receitas com massas, como macarrão, lasanha e ravioli, frequentemente acompanhadas de molhos variados.");
        dishCategoryRepository.save(dishCategory4);

        DishCategory dishCategory5 = new DishCategory();
        dishCategory5.setId(5);
        dishCategory5.setName("Frutos do Mar");
        dishCategory5.setDescription("Pratos com peixes e frutos do mar em diversas preparações.");
        dishCategoryRepository.save(dishCategory5);

        DishCategory dishCategory6 = new DishCategory();
        dishCategory6.setId(6);
        dishCategory6.setName("Pães");
        dishCategory6.setDescription("Receitas de pães caseiros.");
        dishCategoryRepository.save(dishCategory6);

        DishCategory dishCategory7 = new DishCategory();
        dishCategory7.setId(7);
        dishCategory7.setName("Sopas e Caldos");
        dishCategory7.setDescription("Receitas quentes e reconfortantes, que variam de sopas leves a caldos mais encorpados.");
        dishCategoryRepository.save(dishCategory7);
        
        DishCategory dishCategory8 = new DishCategory();
        dishCategory8.setId(8);
        dishCategory8.setName("Prato Típico");
        dishCategory8.setDescription("Pratos tradicionais de uma região ou país, preparados com ingredientes autênticos.");
        dishCategoryRepository.save(dishCategory8);

        DishCategory dishCategory9 = new DishCategory();
        dishCategory9.setId(9);
        dishCategory9.setName("Prato Internacional");
        dishCategory9.setDescription("Receitas representativas de diferentes países, com sabores e tradições de outras culturas.");
        dishCategoryRepository.save(dishCategory9);

        DishCategory dishCategory10 = new DishCategory();
        dishCategory10.setId(10);
        dishCategory10.setName("Sobremesas");
        dishCategory10.setDescription("Pratos doces servidos ao final das refeições, como bolos, tortas, pudins e sorvetes.");
        dishCategoryRepository.save(dishCategory10);

        DishCategory dishCategory11 = new DishCategory();
        dishCategory11.setId(11);
        dishCategory11.setName("Grãos");
        dishCategory11.setDescription("Receitas feitas com grãos como arroz, feijão, lentilhas e quinoa, ideais como pratos principais ou acompanhamentos.");
        dishCategoryRepository.save(dishCategory11);

        DishCategory dishCategory12 = new DishCategory();
        dishCategory12.setId(12);
        dishCategory12.setName("Pratos Nacionais");
        dishCategory12.setDescription("Pratos tradicionais que refletem a identidade gastronômica de um país.");
        dishCategoryRepository.save(dishCategory12);

        DishCategory dishCategory13 = new DishCategory();
        dishCategory13.setId(13);
        dishCategory13.setName("Pratos Rápidos");
        dishCategory13.setDescription("Receitas simples e rápidas, ideais para quem tem pouco tempo, mas não abre mão de uma refeição saborosa.");
        dishCategoryRepository.save(dishCategory13);

        DishCategory dishCategory14 = new DishCategory();
        dishCategory14.setId(14);
        dishCategory14.setName("Vegetariano/Vegano");
        dishCategory14.setDescription("Receitas sem ingredientes de origem animal, feitas com vegetais, grãos e outros alimentos vegetais.");
        dishCategoryRepository.save(dishCategory14);

        DishCategory dishCategory15 = new DishCategory();
        dishCategory15.setId(15);
        dishCategory15.setName("Culinária Fit");
        dishCategory15.setDescription("Pratos saudáveis e nutritivos, com baixo teor calórico, ideais para quem busca uma alimentação balanceada.");
        dishCategoryRepository.save(dishCategory15);

        DishCategory dishCategory16 = new DishCategory();
        dishCategory16.setId(16);
        dishCategory16.setName("Bolos e Tortas Doces");
        dishCategory16.setDescription("Receitas de bolos e tortas doces, como bolos de aniversário, tortas de frutas, mousses e pudins.");
        dishCategoryRepository.save(dishCategory16);

        DishCategory dishCategory17 = new DishCategory();
        dishCategory17.setId(17);
        dishCategory17.setName("Tortas Salgadas");
        dishCategory17.setDescription("Receitas de tortas salgadas, como tortas de frango, carne, legumes e queijos.");
        dishCategoryRepository.save(dishCategory17);

        DishCategory dishCategory18 = new DishCategory();
        dishCategory18.setId(18);
        dishCategory18.setName("Pratos de Festas e Celebrações");
        dishCategory18.setDescription("Receitas especiais para ocasiões festivas, com pratos mais elaborados.");
        dishCategoryRepository.save(dishCategory18);

        DishCategory dishCategory19 = new DishCategory();
        dishCategory19.setId(19);
        dishCategory19.setName("Low Carb");
        dishCategory19.setDescription("Pratos com baixo teor de carboidratos, voltados para dietas com restrição de açúcar e calorias.");
        dishCategoryRepository.save(dishCategory19);

        DishCategory dishCategory20 = new DishCategory();
        dishCategory20.setId(20);
        dishCategory20.setName("Café da Manhã");
        dishCategory20.setDescription("Receitas para o início do dia, como pães, bolos, torradas e sucos, garantindo uma refeição saudável.");
        dishCategoryRepository.save(dishCategory20);

        DishCategory dishCategory21 = new DishCategory();
        dishCategory21.setId(21);
        dishCategory21.setName("Pratos para Crianças");
        dishCategory21.setDescription("Receitas nutritivas e saborosas, pensadas especialmente para o paladar infantil.");
        dishCategoryRepository.save(dishCategory21);
    }
}
