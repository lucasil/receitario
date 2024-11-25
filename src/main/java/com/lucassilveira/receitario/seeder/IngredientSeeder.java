package com.lucassilveira.receitario.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lucassilveira.receitario.model.Ingredient;
import com.lucassilveira.receitario.repository.IngredientRepository;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class IngredientSeeder implements CommandLineRunner {
    
    @Autowired
    private IngredientRepository ingredientRepository;

    public void run(String...args) throws Exception {
        // Criar ingredientes
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1);
        ingredient1.setName("Arroz");
        ingredient1.setDescription("Grão básico em muitas culinárias, usado como acompanhamento ou base para risotos e pilafs.");
        ingredientRepository.save(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2);
        ingredient2.setName("Feijão");
        ingredient2.setDescription("Leguminosa essencial, disponível em várias variedades como preto, carioca e branco, usado em sopas e cozidos.");
        ingredientRepository.save(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3);
        ingredient3.setName("Frango");
        ingredient3.setDescription("Carne versátil, consumida de diversas formas: grelhado, frito, assado ou em caldos.");
        ingredientRepository.save(ingredient3);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setId(4);
        ingredient4.setName("Carne de Boeuf");
        ingredient4.setDescription("Carne bovina consumida em cortes como bife, carne moída, e assados.");
        ingredientRepository.save(ingredient4);

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setId(5);
        ingredient5.setName("Carne de Porco");
        ingredient5.setDescription("Carne versátil, utilizada em cortes como bacon, costelinha e presunto.");
        ingredientRepository.save(ingredient5);

        Ingredient ingredient6 = new Ingredient();
        ingredient6.setId(6);
        ingredient6.setName("Azeite de Oliva");
        ingredient6.setDescription("Óleo saudável, utilizado para cozinhar ou temperar saladas e molhos.");
        ingredientRepository.save(ingredient6);

        Ingredient ingredient7 = new Ingredient();
        ingredient7.setId(7);
        ingredient7.setName("Sal");
        ingredient7.setDescription("Tempera alimentos, essencial para realçar sabores e presente em quase todas as receitas.");
        ingredientRepository.save(ingredient7);

        Ingredient ingredient8 = new Ingredient();
        ingredient8.setId(8);
        ingredient8.setName("Açúcar");
        ingredient8.setDescription("Ingrediente doce, utilizado em sobremesas, conservas e bebidas.");
        ingredientRepository.save(ingredient8);

        Ingredient ingredient9 = new Ingredient();
        ingredient9.setId(9);
        ingredient9.setName("Farinha de Trigo");
        ingredient9.setDescription("Base para pães, bolos, massas e empanados.");
        ingredientRepository.save(ingredient9);

        Ingredient ingredient10 = new Ingredient();
        ingredient10.setId(10);
        ingredient10.setName("Farinha de Milho");
        ingredient10.setDescription("Usada em pães, tortilhas e polenta, é uma alternativa sem glúten.");
        ingredientRepository.save(ingredient10);

        Ingredient ingredient11 = new Ingredient();
        ingredient11.setId(11);
        ingredient11.setName("Maizena");
        ingredient11.setDescription("Amido de milho, utilizado como espessante em sopas, molhos e sobremesas.");
        ingredientRepository.save(ingredient11);

        Ingredient ingredient12 = new Ingredient();
        ingredient12.setId(12);
        ingredient12.setName("Batata");
        ingredient12.setDescription("Tubérculo versátil, consumido cozido, frito, assado ou em purê.");
        ingredientRepository.save(ingredient12);

        Ingredient ingredient13 = new Ingredient();
        ingredient13.setId(13);
        ingredient13.setName("Cebola");
        ingredient13.setDescription("Tempera e adiciona sabor a pratos, usada crua ou cozida.");
        ingredientRepository.save(ingredient13);

        Ingredient ingredient14 = new Ingredient();
        ingredient14.setId(14);
        ingredient14.setName("Alho");
        ingredient14.setDescription("Essencial para refogados, marinadas e molhos, com sabor forte e aromático.");
        ingredientRepository.save(ingredient14);

        Ingredient ingredient15 = new Ingredient();
        ingredient15.setId(15);
        ingredient15.setName("Tomate");
        ingredient15.setDescription("Usado fresco ou cozido, é base para molhos e saladas.");
        ingredientRepository.save(ingredient15);

        Ingredient ingredient16 = new Ingredient();
        ingredient16.setId(16);
        ingredient16.setName("Louro");
        ingredient16.setDescription("Folha aromática, usada em caldos, sopas e guisados.");
        ingredientRepository.save(ingredient16);

        Ingredient ingredient17 = new Ingredient();
        ingredient17.setId(17);
        ingredient17.setName("Pimenta-do-reino");
        ingredient17.setDescription("Tempera pratos com seu sabor picante e levemente amargo.");
        ingredientRepository.save(ingredient17);

        Ingredient ingredient18 = new Ingredient();
        ingredient18.setId(18);
        ingredient18.setName("Curry");
        ingredient18.setDescription("Mistura de especiarias, traz sabor quente e aromático a pratos como curries e sopas.");
        ingredientRepository.save(ingredient18);

        Ingredient ingredient19 = new Ingredient();
        ingredient19.setId(19);
        ingredient19.setName("Cominho");
        ingredient19.setDescription("Tempero terroso e quente, usado em pratos indianos, mexicanos e mediterrâneos.");
        ingredientRepository.save(ingredient19);

        Ingredient ingredient20 = new Ingredient();
        ingredient20.setId(20);
        ingredient20.setName("Canela");
        ingredient20.setDescription("Especiaria doce, usada em sobremesas e pratos salgados.");
        ingredientRepository.save(ingredient20);

        Ingredient ingredient21 = new Ingredient();
        ingredient21.setId(21);
        ingredient21.setName("Orégano");
        ingredient21.setDescription("Erva aromática, popular em massas, pizzas e saladas.");
        ingredientRepository.save(ingredient21);

        Ingredient ingredient22 = new Ingredient();
        ingredient22.setId(22);
        ingredient22.setName("Queijo Parmesão");
        ingredient22.setDescription("Queijo duro e salgado, ideal para ralar sobre massas e risotos.");
        ingredientRepository.save(ingredient22);

        Ingredient ingredient23 = new Ingredient();
        ingredient23.setId(23);
        ingredient23.setName("Manteiga");
        ingredient23.setDescription("Usada para cozinhar, assar ou temperar, adicionando riqueza aos pratos.");
        ingredientRepository.save(ingredient23);

        Ingredient ingredient24 = new Ingredient();
        ingredient24.setId(24);
        ingredient24.setName("Leite");
        ingredient24.setDescription("Ingrediente base para doces, molhos e receitas salgadas, disponível em versões vegetais.");
        ingredientRepository.save(ingredient24);

        Ingredient ingredient25 = new Ingredient();
        ingredient25.setId(25);
        ingredient25.setName("Tempeh");
        ingredient25.setDescription("Produto fermentado à base de soja, rico em proteínas, usado como substituto de carne.");
        ingredientRepository.save(ingredient25);

        Ingredient ingredient26 = new Ingredient();
        ingredient26.setId(26);
        ingredient26.setName("Tapioca");
        ingredient26.setDescription("Derivado da mandioca, usado em panquecas e pães sem glúten.");
        ingredientRepository.save(ingredient26);

        Ingredient ingredient27 = new Ingredient();
        ingredient27.setId(27);
        ingredient27.setName("Açafrão");
        ingredient27.setDescription("Especiaria dourada, suave e levemente amarga, popular na culinária mediterrânea e do Oriente Médio. Seu alto custo se deve ao processo intensivo de colheita.");
        ingredientRepository.save(ingredient27);

        Ingredient ingredient28 = new Ingredient();
        ingredient28.setId(28);
        ingredient28.setName("Abóbora Japonesa (Kabocha)");
        ingredient28.setDescription("Abóbora com casca verde e carne laranja, adocicada e macia, popular em sopas e purês na culinária japonesa.");
        ingredientRepository.save(ingredient28);

        Ingredient ingredient29 = new Ingredient();
        ingredient29.setId(29);
        ingredient29.setName("Alga Nori");
        ingredient29.setDescription("Alga marinha seca, rica em nutrientes como iodo e proteínas, usada em sushi e como tempero umami.");
        ingredientRepository.save(ingredient29);

        Ingredient ingredient30 = new Ingredient();
        ingredient30.setId(30);
        ingredient30.setName("Baobá");
        ingredient30.setDescription("Fruto de uma árvore africana, com polpa rica em vitamina C e sabor ácido, utilizado em sucos e sobremesas.");
        ingredientRepository.save(ingredient30);

        Ingredient ingredient31 = new Ingredient();
        ingredient31.setId(31);
        ingredient31.setName("Berinjela Longa (ou Egípcia)");
        ingredient31.setDescription("Variedade de berinjela mais alongada, menos amarga, usada em pratos asiáticos, grelhada, assada ou frita.");
        ingredientRepository.save(ingredient31);

        Ingredient ingredient32 = new Ingredient();
        ingredient32.setId(32);
        ingredient32.setName("Chá de Kombucha");
        ingredient32.setDescription("Bebida fermentada com probióticos, sabor levemente ácido, conhecida por benefícios à saúde intestinal.");
        ingredientRepository.save(ingredient32);

        Ingredient ingredient33 = new Ingredient();
        ingredient33.setId(33);
        ingredient33.setName("Figo-da-Índia (ou Tuna)");
        ingredient33.setDescription("Fruto de cacto com polpa doce e suculenta, utilizado em sucos, geleias ou consumido fresco.");
        ingredientRepository.save(ingredient33);

        Ingredient ingredient34 = new Ingredient();
        ingredient34.setId(34);
        ingredient34.setName("Grão-de-Bico Preto");
        ingredient34.setDescription("Variedade de grão-de-bico menor e mais escura, com sabor terroso, comum na culinária indiana e rica em proteínas.");
        ingredientRepository.save(ingredient34);

        Ingredient ingredient35 = new Ingredient();
        ingredient35.setId(35);
        ingredient35.setName("Jabuticaba");
        ingredient35.setDescription("Fruta brasileira com casca escura e polpa doce, usada em compotas, sucos e até vinhos.");
        ingredientRepository.save(ingredient35);

        Ingredient ingredient36 = new Ingredient();
        ingredient36.setId(36);
        ingredient36.setName("Kefir");
        ingredient36.setDescription("Bebida fermentada, rica em probióticos, com sabor ácido e textura cremosa, benéfica para a digestão.");
        ingredientRepository.save(ingredient36);

        Ingredient ingredient37 = new Ingredient();
        ingredient37.setId(37);
        ingredient37.setName("Lichia");
        ingredient37.setDescription("Fruta tropical doce e suculenta, consumida fresca ou em sobremesas e sucos.");
        ingredientRepository.save(ingredient37);

        Ingredient ingredient38 = new Ingredient();
        ingredient38.setId(38);
        ingredient38.setName("Maracuja-da-Costa-Rica (ou Maracuja-roxo)");
        ingredient38.setDescription("Maracujá com casca roxa e polpa mais ácida, usado em sucos e sobremesas.");
        ingredientRepository.save(ingredient38);

        Ingredient ingredient39 = new Ingredient();
        ingredient39.setId(39);
        ingredient39.setName("Miso");
        ingredient39.setDescription("Pasta fermentada de soja, arroz ou cevada, com sabor umami, usada em sopas e molhos japoneses.");
        ingredientRepository.save(ingredient39);

        Ingredient ingredient40 = new Ingredient();
        ingredient40.setId(40);
        ingredient40.setName("Semente de Chia");
        ingredient40.setDescription("Semente rica em fibras e ômega-3, usada em smoothies, saladas ou como substituto de ovo em receitas veganas.");
        ingredientRepository.save(ingredient40);

        Ingredient ingredient41 = new Ingredient();
        ingredient41.setId(41);
        ingredient41.setName("Tamarindo");
        ingredient41.setDescription("Fruta ácida, com polpa doce ou azeda, usada em molhos, marinadas e bebidas.");
        ingredientRepository.save(ingredient41);
    }
}
