package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseTest {

    @Test
    public void updateQuality() throws Exception {
        CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                new String[]{"foo","Aged Brie","Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros"},
                new Integer[]{0,11,2,6,-1},
                new Integer[]{0,1,50,49}
        );
    }


    public String doUpdateQuality(String name, int sellIn,int quality) {
        Item[] items = new Item[] {Item.createItem(name,sellIn,quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        //assertThat(app.items[0].name, is("foo"));
        //Approvals.verify();
        return app.items[0].toString();

    }



}
