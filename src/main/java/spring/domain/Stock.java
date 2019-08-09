package spring.domain;

public class Stock {

    //股票代码
    private String  stockCode;
    //股票名称
    private String  stockName;
    //当日开盘价
    private Double  openPrice;
    //昨日收盘价
    private Double  lastPrice;
    //当前实时价格
    private Double  currPrice;
    //当日最高价格
    private Double  highPrice;
    //当日最低价格
    private Double  lowPrice;
    //竞价买一报价
    private Double  buyPrice;
    //竞价卖一报价
    private Double  salePrice;
    //当日成交股票数
    private Integer dealStock;
    //当日成交金额
    private Double  dealFee;
    //买一数量
    private Integer buy1Total;
    //买一价格
    private Double  buy1Price;
    //买二数量
    private Integer buy2Total;
    //买二价格
    private Double  buy2Price;
    //买三数量
    private Integer buy3Total;
    //买三价格
    private Double  buy3Price;
    //买四数量
    private Integer buy4Total;
    //买四价格
    private Double  buy4Price;
    //买五数量
    private Integer buy5Total;
    //买五价格
    private Double  buy5Price;
    //卖一数量
    private Integer sale1Total;
    //卖一价格
    private Double  sale1Price;
    //买二数量
    private Integer sale2Total;
    //买二价格
    private Double  sale2Price;
    //买三数量
    private Integer sale3Total;
    //买三价格
    private Double  sale3Price;
    //买四数量
    private Integer sale4Total;
    //买四价格
    private Double  sale4Price;
    //买五数量
    private Integer sale5Total;
    //买五价格
    private Double  sale5Price;
    //日期
    private String  date;
    //时间
    private String  time;


    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Double getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(Double currPrice) {
        this.currPrice = currPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getDealStock() {
        return dealStock;
    }

    public void setDealStock(Integer dealStock) {
        this.dealStock = dealStock;
    }

    public Double getDealFee() {
        return dealFee;
    }

    public void setDealFee(Double dealFee) {
        this.dealFee = dealFee;
    }

    public Integer getBuy1Total() {
        return buy1Total;
    }

    public void setBuy1Total(Integer buy1Total) {
        this.buy1Total = buy1Total;
    }

    public Double getBuy1Price() {
        return buy1Price;
    }

    public void setBuy1Price(Double buy1Price) {
        this.buy1Price = buy1Price;
    }

    public Integer getBuy2Total() {
        return buy2Total;
    }

    public void setBuy2Total(Integer buy2Total) {
        this.buy2Total = buy2Total;
    }

    public Double getBuy2Price() {
        return buy2Price;
    }

    public void setBuy2Price(Double buy2Price) {
        this.buy2Price = buy2Price;
    }

    public Integer getBuy3Total() {
        return buy3Total;
    }

    public void setBuy3Total(Integer buy3Total) {
        this.buy3Total = buy3Total;
    }

    public Double getBuy3Price() {
        return buy3Price;
    }

    public void setBuy3Price(Double buy3Price) {
        this.buy3Price = buy3Price;
    }

    public Integer getBuy4Total() {
        return buy4Total;
    }

    public void setBuy4Total(Integer buy4Total) {
        this.buy4Total = buy4Total;
    }

    public Double getBuy4Price() {
        return buy4Price;
    }

    public void setBuy4Price(Double buy4Price) {
        this.buy4Price = buy4Price;
    }

    public Integer getBuy5Total() {
        return buy5Total;
    }

    public void setBuy5Total(Integer buy5Total) {
        this.buy5Total = buy5Total;
    }

    public Double getBuy5Price() {
        return buy5Price;
    }

    public void setBuy5Price(Double buy5Price) {
        this.buy5Price = buy5Price;
    }

    public Integer getSale1Total() {
        return sale1Total;
    }

    public void setSale1Total(Integer sale1Total) {
        this.sale1Total = sale1Total;
    }

    public Double getSale1Price() {
        return sale1Price;
    }

    public void setSale1Price(Double sale1Price) {
        this.sale1Price = sale1Price;
    }

    public Integer getSale2Total() {
        return sale2Total;
    }

    public void setSale2Total(Integer sale2Total) {
        this.sale2Total = sale2Total;
    }

    public Double getSale2Price() {
        return sale2Price;
    }

    public void setSale2Price(Double sale2Price) {
        this.sale2Price = sale2Price;
    }

    public Integer getSale3Total() {
        return sale3Total;
    }

    public void setSale3Total(Integer sale3Total) {
        this.sale3Total = sale3Total;
    }

    public Double getSale3Price() {
        return sale3Price;
    }

    public void setSale3Price(Double sale3Price) {
        this.sale3Price = sale3Price;
    }

    public Integer getSale4Total() {
        return sale4Total;
    }

    public void setSale4Total(Integer sale4Total) {
        this.sale4Total = sale4Total;
    }

    public Double getSale4Price() {
        return sale4Price;
    }

    public void setSale4Price(Double sale4Price) {
        this.sale4Price = sale4Price;
    }

    public Integer getSale5Total() {
        return sale5Total;
    }

    public void setSale5Total(Integer sale5Total) {
        this.sale5Total = sale5Total;
    }

    public Double getSale5Price() {
        return sale5Price;
    }

    public void setSale5Price(Double sale5Price) {
        this.sale5Price = sale5Price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", openPrice=" + openPrice +
                ", lastPrice=" + lastPrice +
                ", currPrice=" + currPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", buyPrice=" + buyPrice +
                ", salePrice=" + salePrice +
                ", dealStock=" + dealStock +
                ", dealFee=" + dealFee +
                ", buy1Total=" + buy1Total +
                ", buy1Price=" + buy1Price +
                ", buy2Total=" + buy2Total +
                ", buy2Price=" + buy2Price +
                ", buy3Total=" + buy3Total +
                ", buy3Price=" + buy3Price +
                ", buy4Total=" + buy4Total +
                ", buy4Price=" + buy4Price +
                ", buy5Total=" + buy5Total +
                ", buy5Price=" + buy5Price +
                ", sale1Total=" + sale1Total +
                ", sale1Price=" + sale1Price +
                ", sale2Total=" + sale2Total +
                ", sale2Price=" + sale2Price +
                ", sale3Total=" + sale3Total +
                ", sale3Price=" + sale3Price +
                ", sale4Total=" + sale4Total +
                ", sale4Price=" + sale4Price +
                ", sale5Total=" + sale5Total +
                ", sale5Price=" + sale5Price +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
