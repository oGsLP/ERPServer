package rmi;

import objects.ResultMessage;
import po.GoodsOverflowPO;
import service.blservice.*;
import service.blservice.Impl.*;
import vo.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Set;

public class DataRemoteObject extends UnicastRemoteObject implements ClassifyBLService , GoodsBLService,
    GoodsSaleBLService, GoodsSaleReturnBLService, GoodsStockBLService, GoodsStockReturnBLService, MemberBLService,
    SaleBLService, SaleReturnBLService, StockBLService, StockReturnBLService, UserBLService, GoodsLackBLService,
        GoodsOverflowBLService, PresentBLService, LackListBLService, OverflowListBLService, PresentListBLService, GoodsWarningMessageBLService {
    private static final long serialVersionUID = 4029039744279087114L;

    private ClassifyBLService classifyBLService;

    private GoodsBLService goodsBLService;

    private GoodsSaleBLService goodsSaleBLService;
    private GoodsSaleReturnBLService goodsSaleReturnBLService;
    private GoodsStockBLService goodsStockBLService;
    private GoodsStockReturnBLService goodsStockReturnBLService;

    private MemberBLService memberBLService;

    private SaleBLService saleBLService;
    private SaleReturnBLService saleReturnBLService;
    private StockBLService stockBLService;
    private StockReturnBLService stockReturnBLService;

    private UserBLService userBLService;

    private GoodsLackBLService goodsLackBLService;
    private GoodsOverflowBLService goodsOverflowBLService;
    private PresentBLService presentBLService;

    private LackListBLService lackListBLService;
    private OverflowListBLService overflowListBLService;
    private PresentListBLService presentListBLService;
    private GoodsWarningMessageBLService goodsWarningMessageBLService;

    protected DataRemoteObject() throws RemoteException{
        super();
        classifyBLService = new ClassifyBLServiceImpl();


        goodsBLService = new GoodsBLServiceImpl();

        goodsSaleBLService = new GoodsSaleBLServiceImpl();
        goodsSaleReturnBLService = new GoodsSaleReturnBLServiceImpl();
        goodsStockBLService = new GoodsStockBLServiceImpl();
        goodsStockReturnBLService = new GoodsStockReturnBLServiceImpl();

        memberBLService = new MemberBLServiceImpl();

        saleBLService = new SaleBLServiceImpl();
        saleReturnBLService = new SaleReturnBLServiceImpl();
        stockBLService = new StockBLServiceImpl();
        stockReturnBLService = new StockReturnBLServiceImpl();

        userBLService = new UserBLServiceImpl();

        goodsLackBLService = new GoodsLackBLServiceImpl();
        goodsOverflowBLService = new GoodsOverflowBLServiceImpl();
        presentBLService = new PresentBLServiceImpl();

        lackListBLService = new LackListBLServiceImpl();
        overflowListBLService = new OverflowListBLServiceImpl();
        presentBLService = new PresentBLServiceImpl();
        presentListBLService = new PresentListBLServiceImpl();
        goodsWarningMessageBLService = new GoodsWarningMessageBLServiceImpl();
    }


    @Override
    public ResultMessage addClassify(ClassifyVO vo) throws RemoteException {
        return classifyBLService.addClassify(vo);
    }

    @Override
    public ResultMessage deleteClassify(ClassifyVO vo) throws RemoteException {
        return classifyBLService.deleteClassify(vo);
    }

    @Override
    public ResultMessage updateClassify(ClassifyVO vo) throws RemoteException {
        return classifyBLService.updateClassify(vo);
    }

    @Override
    public ArrayList<GoodsVO> getGoods(ClassifyVO vo) throws RemoteException {
        return classifyBLService.getGoods(vo);
    }




    @Override
    public ResultMessage addGoods(GoodsVO vo) throws RemoteException {
        return goodsBLService.addGoods(vo);
    }

    @Override
    public ResultMessage deleteGoods(GoodsVO vo) throws RemoteException {
        return goodsBLService.deleteGoods(vo);
    }

    @Override
    public ResultMessage updateGoods(GoodsVO vo) throws RemoteException {
        return goodsBLService.updateGoods(vo);
    }

    @Override
    public ArrayList<GoodsVO> findGoods(String number, String name, String type) throws RemoteException {
        return goodsBLService.findGoods(number, name, type);
    }

    @Override
    public ResultMessage addGoodsSale(GoodsVO vo, int saleNumber, double price, String remark) throws RemoteException {
        return goodsSaleBLService.addGoodsSale(vo, saleNumber, price, remark);
    }

    @Override
    public ResultMessage deleteGoodsSale(GoodsSaleVO vo) throws RemoteException {
        return goodsSaleBLService.deleteGoodsSale(vo);
    }

    @Override
    public ResultMessage updateGoodsSale(GoodsSaleVO vo) throws RemoteException {
        return goodsSaleBLService.updateGoodsSale(vo);
    }

    @Override
    public ResultMessage addGoodsSaleReturn(GoodsVO vo, int saleReturnNumber, double price, String remark) throws RemoteException {
        return goodsSaleReturnBLService.addGoodsSaleReturn(vo, saleReturnNumber, price, remark);
    }

    @Override
    public ResultMessage deleteGoodsSaleReturn(GoodsSaleReturnVO vo) throws RemoteException {
        return goodsSaleReturnBLService.deleteGoodsSaleReturn(vo);
    }

    @Override
    public ResultMessage updateGoodsSaleReturn(GoodsSaleReturnVO vo) throws RemoteException {
        return goodsSaleReturnBLService.updateGoodsSaleReturn(vo);
    }

    @Override
    public ResultMessage addGoodsStock(GoodsVO vo, int stockNumber, String remark) throws RemoteException {
        return goodsStockBLService.addGoodsStock(vo, stockNumber, remark);
    }

    @Override
    public ResultMessage addGoodsStock(GoodsVO vo, int stockNumber, double price, String remark) throws RemoteException {
        return goodsStockBLService.addGoodsStock(vo, stockNumber, price, remark);
    }

    @Override
    public ResultMessage deleteGoodsStock(GoodsStockVO vo) throws RemoteException {
        return goodsStockBLService.deleteGoodsStock(vo);
    }

    @Override
    public ResultMessage updateGoodsStock(GoodsStockVO vo) throws RemoteException {
        return goodsStockBLService.updateGoodsStock(vo);
    }

    @Override
    public ResultMessage addGoodsStockReturn(GoodsVO vo, int stockReturnNumber, double price, String remark) throws RemoteException {
        return goodsStockReturnBLService.addGoodsStockReturn(vo, stockReturnNumber, price, remark);
    }

    @Override
    public ResultMessage deleteGoodsStockReturn(GoodsStockReturnVO vo) throws RemoteException {
        return goodsStockReturnBLService.deleteGoodsStockReturn(vo);
    }

    @Override
    public ResultMessage updateGoodsStockReturn(GoodsStockReturnVO vo) throws RemoteException {
        return goodsStockReturnBLService.updateGoodsStockReturn(vo);
    }

    @Override
    public ResultMessage addMember(MemberVO vo) throws RemoteException {
        return memberBLService.addMember(vo);
    }


    @Override
    public ResultMessage deleteMember(MemberVO vo) throws RemoteException {
        return memberBLService.deleteMember(vo);
    }

    @Override
    public ResultMessage updateMember(MemberVO vo) throws RemoteException {
        return memberBLService.updateMember(vo);
    }

    @Override
    public MemberVO findMember(int number) {
        return memberBLService.findMember(number);
    }

    @Override
    public ResultMessage addSale(String retailer, String salesman, String operator, double discount,
                                 double voucher, String remark, Set<GoodsSaleVO> set) throws RemoteException {

        return saleBLService.addSale(retailer, salesman, operator, discount, voucher, remark, set);
    }

    @Override
    public ResultMessage deleteSale(SaleVO vo) throws RemoteException {
        return saleBLService.deleteSale(vo);
    }

    @Override
    public ResultMessage updateSale(SaleVO vo) throws RemoteException {
        return saleBLService.updateSale(vo);
    }

    @Override
    public ArrayList<SaleVO> getSaleProcessList() throws RemoteException {
        return saleBLService.getSaleProcessList();
    }

    @Override
    public void passSaleCheck(SaleVO vo) throws RemoteException {
        saleBLService.passSaleCheck(vo);
    }

    @Override
    public void failSaleCheck(SaleVO vo) throws RemoteException {
        saleBLService.failSaleCheck(vo);
    }

    @Override
    public SaleVO addSaleRed(SaleVO vo) throws RemoteException {
        return saleBLService.addSaleRed(vo);
    }

    @Override
    public ArrayList<SaleVO> getSale(String startTime, String endTime, String userName, String memberName) throws RemoteException {
        return saleBLService.getSale(startTime, endTime, userName, memberName);
    }

    @Override
    public ArrayList<SaleVO> getSalFail() throws RemoteException {
        return saleBLService.getSalFail();
    }

    @Override
    public ResultMessage addSaleReturn(String retailer, String salesman, String operator, String remark,
                                       Set<GoodsSaleReturnVO> set) throws RemoteException {
        return saleReturnBLService.addSaleReturn(retailer, salesman, operator, remark, set);
    }

    @Override
    public ResultMessage deleteSaleReturn(SaleReturnVO vo) throws RemoteException {
        return saleReturnBLService.deleteSaleReturn(vo);
    }

    @Override
    public ResultMessage updateSaleReturn(SaleReturnVO vo) throws RemoteException {
        return saleReturnBLService.updateSaleReturn(vo);
    }

    @Override
    public ArrayList<SaleReturnVO> getSaleReturnProcessList() throws RemoteException {
        return saleReturnBLService.getSaleReturnProcessList();
    }

    @Override
    public void passSaleReturnCheck(SaleReturnVO vo) throws RemoteException {
        saleReturnBLService.passSaleReturnCheck(vo);
    }


    @Override
    public void failSaleReturnCheck(SaleReturnVO vo) throws RemoteException {
        saleReturnBLService.failSaleReturnCheck(vo);
    }

    @Override
    public ArrayList<SaleReturnVO> getSaleReturn(String startTime, String endTime, String userName,
                                                 String memberName) throws RemoteException {
        return saleReturnBLService.getSaleReturn(startTime, endTime, userName, memberName);
    }

    @Override
    public ArrayList<SaleReturnVO> getSaleReturnFail() throws RemoteException {
        return saleReturnBLService.getSaleReturnFail();
    }

    @Override
    public ResultMessage addStock(StockVO vo) throws RemoteException {
        return stockBLService.addStock(vo);
    }

    @Override
    public ResultMessage addStock(String provider, String remark, Set<GoodsStockVO> set) throws RemoteException {
        return stockBLService.addStock(provider, remark, set);
    }

    @Override
    public ResultMessage deleteStock(StockVO vo) throws RemoteException {
        return stockBLService.deleteStock(vo);
    }

    @Override
    public ResultMessage updateStock(StockVO vo) throws RemoteException {
        return stockBLService.updateStock(vo);
    }

    @Override
    public ArrayList<StockVO> getStockProcessList() throws RemoteException {
        return stockBLService.getStockProcessList();
    }

    @Override
    public void passStockCheck(StockVO vo) throws RemoteException {
        stockBLService.passStockCheck(vo);
    }

    @Override
    public void failStockCheck(StockVO vo) throws RemoteException {
        stockBLService.failStockCheck(vo);
    }

    @Override
    public ArrayList<StockVO> getStock(String startTime, String endTime, String userName, String memberName) throws RemoteException {
        return stockBLService.getStock(startTime, endTime, userName, memberName);
    }

    @Override
    public ArrayList<StockVO> getStockFail() throws RemoteException {
        return stockBLService.getStockFail();
    }

    @Override
    public ResultMessage addStockReturn(String provider, String remark, Set<GoodsStockReturnVO> set) throws RemoteException {
        return stockReturnBLService.addStockReturn(provider, remark, set);
    }

    @Override
    public ResultMessage deleteStockReturn(StockReturnVO vo) throws RemoteException {
        return stockReturnBLService.deleteStockReturn(vo);
    }

    @Override
    public ResultMessage updateStockReturn(StockReturnVO vo) throws RemoteException {
        return stockReturnBLService.updateStockReturn(vo);
    }

    @Override
    public ArrayList<StockReturnVO> getStockReturnProcessList() throws RemoteException {
        return stockReturnBLService.getStockReturnProcessList();
    }

    @Override
    public void passStockReturnCheck(StockReturnVO vo) throws RemoteException {
        stockReturnBLService.passStockReturnCheck(vo);
    }

    @Override
    public void failStockReturnCheck(StockReturnVO vo) throws RemoteException {
        stockReturnBLService.failStockReturnCheck(vo);
    }

    @Override
    public ArrayList<StockReturnVO> getStockReturn(String startTime, String endTime,
                                                   String userName, String memberName) throws RemoteException {
        return stockReturnBLService.getStockReturn(startTime, endTime, userName, memberName);
    }

    @Override
    public ArrayList<StockReturnVO> getStockReturnFail() throws RemoteException {
        return stockReturnBLService.getStockReturnFail();
    }

    @Override
    public ResultMessage register(UserVO vo) {
        return userBLService.register(vo);
    }

    @Override
    public ResultMessage check(String name, String password) {
        return userBLService.check(name, password);
    }

    @Override
    public ResultMessage updatePassword(String name, String password, String type) {
        return userBLService.updatePassword(name, password, type);
    }

    @Override
    public UserVO getUserVO(String name) {
        return userBLService.getUserVO(name);
    }

    @Override
    public ResultMessage addGoodsLack(GoodsLackVO vo) {
        return goodsLackBLService.addGoodsLack(vo);
    }

    @Override
    public ResultMessage deleteGoodsLack(GoodsLackVO vo) {
        return goodsLackBLService.deleteGoodsLack(vo);
    }

    @Override
    public ResultMessage update(GoodsLackVO vo) {
        return goodsLackBLService.update(vo);
    }

    @Override
    public ResultMessage addLackList(LackListVO vo) {
        return lackListBLService.addLackList(vo);
    }

    @Override
    public ResultMessage deleteLackList(LackListVO vo) {
        return lackListBLService.deleteLackList(vo);
    }

    @Override
    public ResultMessage update(LackListVO vo) {
        return lackListBLService.update(vo);
    }

    @Override
    public ArrayList<LackListVO> getLackList(String startTime, String endTime, String userName) {
        return lackListBLService.getLackList(startTime, endTime, userName);
    }

    @Override
    public LackListVO addLackListRed(LackListVO vo) {
        return lackListBLService.addLackListRed(vo);
    }

    @Override
    public ResultMessage addOverflowList(OverflowListVO vo) {
        return overflowListBLService.addOverflowList(vo);
    }

    @Override
    public ResultMessage deleteOverlowList(OverflowListVO vo) {
        return overflowListBLService.deleteOverlowList(vo);
    }

    @Override
    public ResultMessage updateOverflowList(OverflowListVO vo) {
        return overflowListBLService.updateOverflowList(vo);
    }

    @Override
    public ArrayList<OverflowListVO> getOverflowList(String startTime, String endTime, String userName) {
        return overflowListBLService.getOverflowList(startTime, endTime, userName);
    }

    @Override
    public OverflowListVO addOverflowListRed(OverflowListVO vo) {
        return overflowListBLService.addOverflowListRed(vo);
    }

    @Override
    public ResultMessage addPresent(PresentVO vo) {
        return presentBLService.addPresent(vo);
    }

    @Override
    public ResultMessage deletePresent(PresentVO vo) {
        return presentBLService.deletePresent(vo);
    }

    @Override
    public ResultMessage updatePresent(PresentVO vo) {
        return presentBLService.updatePresent(vo);
    }

    @Override
    public ResultMessage addPresentList(PresentListVO vo) {
        return presentListBLService.addPresentList(vo);
    }

    @Override
    public ResultMessage deletePresentList(PresentListVO vo) {
        return presentListBLService.deletePresentList(vo);
    }

    @Override
    public ResultMessage update(PresentListVO vo) {
        return presentListBLService.update(vo);
    }

    @Override
    public ArrayList<PresentListVO> getOverflowList(String startTime, String endTime, String userName, String memberName) {
        return presentListBLService.getOverflowList(startTime, endTime, userName, memberName);
    }

    @Override
    public PresentListVO addPresentListRed(PresentListVO vo) {
        return presentListBLService.addPresentListRed(vo);
    }

    @Override
    public ResultMessage addGoodsOverflow(GoodsOverflowVO vo) {
        return goodsOverflowBLService.addGoodsOverflow(vo);
    }

    @Override
    public ResultMessage deleteGoodsOverflow(GoodsOverflowVO vo) {
        return goodsOverflowBLService.deleteGoodsOverflow(vo);
    }

    @Override
    public ResultMessage update(GoodsOverflowVO vo) {
        return goodsOverflowBLService.update(vo);
    }

    @Override
    public ArrayList<GoodsVO> getWarningMessage(int number) {
        return goodsWarningMessageBLService.getWarningMessage(number);
    }
}
