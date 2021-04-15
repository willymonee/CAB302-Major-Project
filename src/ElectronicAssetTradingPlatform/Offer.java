package ElectronicAssetTradingPlatform;

import java.time.LocalDate;

public abstract class Offer {
    private int orderID;
    private Asset asset;
    private int quantity;
    private float pricePerUnit;
    private int userID;
    private int organisationalUnitID;
    private LocalDate dateResolved;

    /**
     * Constructor for trade offer
     *
     * @param orderID Unique ID for offer (either buy or sell)
     * @param asset Name of the asset to be bought or sold
     * @param quantity Quantity of asset
     * @param pricePerUnit Price of the asset
     * @param userID The ID of the user who made the offer
     * @param organisationalUnitID The ID of the organisation whose assets and credits will be affected
     */
    public Offer(int orderID, Asset asset, int quantity, float pricePerUnit, int organisationalUnitID, int userID) {
        this.orderID = orderID;
        this.asset = asset;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.organisationalUnitID = organisationalUnitID;
        this.userID = userID;
    }

    public abstract class tryResolveOffer() {

    }
}
