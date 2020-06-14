package com.mabaya.campaigner.setup;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.model.Category;
import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.model.Seller;
import com.mabaya.campaigner.services.campaign.CampaignService;
import com.mabaya.campaigner.services.category.CategoryService;
import com.mabaya.campaigner.services.product.ProductService;
import com.mabaya.campaigner.services.seller.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class InitDataLoad implements CommandLineRunner {

    public Map<Integer, Category> categoryMap = new HashMap<>();
    public Map<Integer, Product> productMap = new HashMap<>();
    public Map<Integer, Seller> sellerMap = new HashMap<>();
    public Map<Integer, Campaign> campaignMap = new HashMap<>();

    public Map<Integer, Set<Integer>> categoryProductIndex = new HashMap<>();
    public Map<Integer, Set<Integer>> sellerProductIndex = new HashMap<>();

    private final CategoryService categoryService;
    private final ProductService productService;
    private final SellerService sellerService;
    private final CampaignService campaignService;

    public InitDataLoad(CategoryService categoryService, ProductService productService, SellerService sellerService, CampaignService campaignService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.sellerService = sellerService;
        this.campaignService = campaignService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("loading data...");
        loadCategories();
        loadSellers();
        loadProducts();

        log.info("loaded " + productMap.size() + " products");
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

        productService.save(jack_daniels, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(jim_beam, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(wild_turkey, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(glenlivet, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(glenfiddich, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(bushmills, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(jameson, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(perrier, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(san_pellegrino, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(schweppes, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(snyders, productMap, categoryProductIndex, sellerProductIndex);
        productService.save(pringles, productMap, categoryProductIndex, sellerProductIndex);

    }

    private void loadSellers() {
        Seller paneco = Seller.builder().name("Paneco").build();
        Seller haturki = Seller.builder().name("Haturki").build();
        Seller mashkaot = Seller.builder().name("Sar Hamashkaot").build();

        sellerService.save(paneco, sellerMap);
        sellerService.save(haturki, sellerMap);
        sellerService.save(mashkaot, sellerMap);
    }

    private void loadCategories() {
        Category whisky = Category.builder().title("Whisky").build();
        Category soda = Category.builder().title("Soda").build();
        Category snacks = Category.builder().title("Snacks").build();

        categoryService.save(whisky, categoryMap);
        categoryService.save(soda, categoryMap);
        categoryService.save(snacks, categoryMap);
    }
}
