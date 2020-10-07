package commerceIq.task.prediction;

import java.util.List;

public class PredictOutOfStock {

    class ProductInformation {

        /**
         * Product name
         */
        String uniqueProductName;

        /**
         * Current product units in stock at warehouse
         */
        Integer currentUnitsInStockAtWarehouse;

        /**
         * Forecasted product units that will be sold from warehouse in future weeks
         * Eg: if this week 10 units, next week 20 units and week after 30 units
         * =new ArrayList<>(List.of(10,20,30));
         */
        List<Integer> forecastedUnitsToBeSoldFromWarehouseInEachComingWeek;


        /**
         * Product units that will come in warehouse
         * Eg: if this week 15 units, next week 25 units and week after 35 units
         * =new ArrayList<>(List.of(15,25,35));
         */
        List<Integer> unitsThatWillComeInWarehouseStockInComingEachWeek;
    }

    /**
     * Check if product can go out of stock within N weeks
     *
     * @param p
     * @param WeeksToCheckForOutOfStock
     * @return
     */
    public boolean canProductGoOutOfStockInComingNWeeks(ProductInformation p, int WeeksToCheckForOutOfStock) {

        int unitsThatCouldBeSoldWithinWeeksToCheckForOutOfStock = p.forecastedUnitsToBeSoldFromWarehouseInEachComingWeek.stream()
                .limit(WeeksToCheckForOutOfStock)
                .mapToInt(Integer::valueOf)
                .sum();

        int unitsThatWillComeInWarehouseWithinWeeksToCheckForOutOfStock = p.unitsThatWillComeInWarehouseStockInComingEachWeek.stream()
                .limit(WeeksToCheckForOutOfStock)
                .mapToInt(Integer::valueOf)
                .sum();


        return (unitsThatCouldBeSoldWithinWeeksToCheckForOutOfStock >= (p.currentUnitsInStockAtWarehouse + unitsThatWillComeInWarehouseWithinWeeksToCheckForOutOfStock)) ? true : false;
    }

}
