class Prize {
    private int prizeId;
    private String prizeName;
    private int prizeCost;
    private int prizeWorth;

    public Prize(int id, String name, int cost, int worth) {
        this.prizeId = id;
        this.prizeName = name;
        this.prizeCost = cost;
        this.prizeWorth = worth;
    }
    
    public int getPrizeId() {
        return prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public int getPrizeCost() {
        return prizeCost;
    }

    public int getPrizeWorth() {
        return prizeWorth;
    }
}