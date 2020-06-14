package com.mabaya.campaigner.persist;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.model.Category;
import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.model.Seller;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class DataStructures {

    public Map<Integer, Category> categoryMap = new HashMap<>();
    public Map<Integer, Product> productMap = new HashMap<>();
    public Map<Integer, Seller> sellerMap = new HashMap<>();
    public Map<Integer, Campaign> campaignMap = new HashMap<>();

    public Map<Integer, Set<Integer>> categoryProductIndex = new HashMap<>();
    public Map<Integer, Set<Integer>> sellerProductIndex = new HashMap<>();
    public Map<Integer, Set<Integer>> productCampaignIndex = new HashMap<>();

}
