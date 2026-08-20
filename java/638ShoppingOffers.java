class Solution {
    int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<String, Integer> map) {
        String key = needs.toString();
        if (map.containsKey(key))
            return map.get(key);

        int cost = 0;
        for (int i = 0; i < needs.size(); ++i) {
            cost += price.get(i) * needs.get(i);
        }
        
        for (List<Integer> sp: special) {
            List<Integer> newNeeds = newNeeds(needs, sp);
            if (newNeeds != null) {
                cost = Math.min(cost, sp.get(sp.size() - 1) + shoppingOffers(price, special, newNeeds, map));
            }
        }
        
        map.put(key, cost);
        
        return cost;
    }
    
    List<Integer> newNeeds(List<Integer> needs, List<Integer> sp) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < needs.size(); ++i) {
            if (needs.get(i) < sp.get(i))
                return null;
            res.add(needs.get(i) - sp.get(i));
        }
        
        return res;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> map = new HashMap<>();
        return shoppingOffers(price, special, needs, map);
    }
}

===========================================================================================

class Solution {
    int shopping(Integer[] priceList, List<List<Integer>> special,List<Integer> shopList, Map<List<Integer>, Integer> map) {
        if (map.containsKey(shopList)) {
            return map.get(shopList);
        }

        Integer[] shopArr = shopList.toArray(new Integer[0]);
        int cost = 0;
        for (int i = 0; i < shopArr.length; ++i) {
            cost += priceList[i] * shopArr[i];
        }

        for (List<Integer> discount: special) {
            int i = 0;
            int newCost = discount.get(discount.size() - 1);
            List<Integer> newShopList = new ArrayList<>();
            boolean canUse = true;
            for (int d: discount) {
                if (i == shopArr.length) {
                    break;
                }
                if (shopArr[i] < d) {
                    canUse = false;
                    break;
                }

                newShopList.add(shopArr[i] - d);
                ++i;
            }
            if (canUse) {
                newCost += shopping(priceList, special, newShopList, map);
                if (newCost < cost) {
                    cost = newCost;
                }
            }
        }

        map.put(shopList, cost);
        return cost;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        Integer[] priceList = price.toArray(new Integer[0]);
        return shopping(priceList, special, needs, map);
    }
}
