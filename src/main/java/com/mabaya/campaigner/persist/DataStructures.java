package com.mabaya.campaigner.persist;

import com.mabaya.campaigner.model.Campaign;
import com.mabaya.campaigner.model.Category;
import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.model.Seller;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataStructures {

    public Map<Integer, Category> categoryMap = new HashMap<>();
    public Map<Integer, Product> productMap = new HashMap<>();
    public Map<Integer, Seller> sellerMap = new HashMap<>();
    public Map<Integer, Campaign> campaignMap = new HashMap<>();

    public Map<String, Integer> categoryNameIdMap = new HashMap<>();
    public Map<Integer, Set<Integer>> categoryProductIndex = new HashMap<>();
    public Map<Integer, Set<Integer>> sellerProductIndex = new HashMap<>();
    public Map<Integer, Set<Integer>> productCampaignIndex = new HashMap<>();

    public TreeMap<Double, Campaign> campaignOrderedByBidMap = new TreeMap<>(Collections.reverseOrder());
}
