package com.mabaya.campaigner.setup;

import com.mabaya.campaigner.model.*;
import com.mabaya.campaigner.persist.DataStructures;
import com.mabaya.campaigner.services.campaign.CampaignService;
import com.mabaya.campaigner.services.category.CategoryService;
import com.mabaya.campaigner.services.product.ProductService;
import com.mabaya.campaigner.services.seller.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InitDataLoad implements CommandLineRunner {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final SellerService sellerService;
    private final CampaignService campaignService;
    private final DataStructures dataStructures;

    public InitDataLoad(CategoryService categoryService, ProductService productService, SellerService sellerService, CampaignService campaignService, DataStructures dataStructures) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.sellerService = sellerService;
        this.campaignService = campaignService;
        this.dataStructures = dataStructures;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("loading data...");
        loadCategories();
        loadSellers();
        loadProducts();
        loadCampaign();

        log.info("loaded " + dataStructures.productMap.size() + " products");
    }

    private void loadCampaign() {
        Campaign campaign1 = Campaign.builder().name("Paneco 1").sellerId(1).bid(1000.0).build();
        campaignService.save(campaign1);
    }

    private void loadProducts() {
        Product jack_daniels = Product.builder().sellerId(1).categoryId(1).serialNumber(1000).title("Jack Daniels").price(120.0).build();
        Product jim_beam = Product.builder().sellerId(1).categoryId(1).serialNumber(1001).title("Jim Beam").price(130.0).build();
        Product wild_turkey = Product.builder().sellerId(1).categoryId(1).serialNumber(1002).title("Wild Turkey").price(140.0).build();

        Product glenlivet = Product.builder().sellerId(2).categoryId(1).serialNumber(2000).title("Glenlivet").price(140.0).build();
        Product glenfiddich = Product.builder().sellerId(2).categoryId(1).serialNumber(2001).title("Glenfiddich").price(150.0).build();

        Product bushmills = Product.builder().sellerId(3).categoryId(1).serialNumber(3000).title("Bushmills").price(160.0).build();
        Product jameson = Product.builder().sellerId(3).categoryId(1).serialNumber(3001).title("Jameson").price(170.0).build();

        Product perrier = Product.builder().sellerId(1).categoryId(2).serialNumber(4000).title("Perrier").price(10.0).build();
        Product san_pellegrino = Product.builder().sellerId(2).categoryId(2).serialNumber(4001).title("San Pellegrino").price(11.0).build();
        Product schweppes = Product.builder().sellerId(3).categoryId(2).serialNumber(4001).title("Schweppes").price(11.0).build();

        Product snyders = Product.builder().sellerId(3).categoryId(3).serialNumber(5000).title("Snyder's").price(5.0).build();
        Product pringles = Product.builder().sellerId(3).categoryId(3).serialNumber(5001).title("Pringles").price(6.0).build();

        productService.save(jack_daniels);
        productService.save(jim_beam);
        productService.save(wild_turkey);
        productService.save(glenlivet);
        productService.save(glenfiddich);
        productService.save(bushmills);
        productService.save(jameson);
        productService.save(perrier);
        productService.save(san_pellegrino);
        productService.save(schweppes);
        productService.save(snyders);
        productService.save(pringles);

    }

    private void loadSellers() {
        Seller paneco = Seller.builder().name("Paneco").build();
        Seller haturki = Seller.builder().name("Haturki").build();
        Seller mashkaot = Seller.builder().name("Sar Hamashkaot").build();

        sellerService.save(paneco);
        sellerService.save(haturki);
        sellerService.save(mashkaot);
    }

    private void loadCategories() {
        Category whisky = Category.builder().title("Whisky").build();
        Category soda = Category.builder().title("Soda").build();
        Category snacks = Category.builder().title("Snacks").build();

        categoryService.save(whisky);
        categoryService.save(soda);
        categoryService.save(snacks);
    }
}
