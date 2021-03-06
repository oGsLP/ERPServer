package service.dataservice.Impl;

import objects.DateHelper;
import objects.HQLTools;
import objects.ResultMessage;
import po.GoodsPO;
import po.GoodsSalePO;
import po.MemberPO;
import po.SalePO;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import service.dataservice.SaleDataService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SaleDataServiceImpl implements SaleDataService {
DataFactory dataFactory = new DataFactoryImpl();
DateHelper dateHelper = new DateHelper();
    @Override
    public ResultMessage add(SalePO po) {
        if(po == null)
            return ResultMessage.Fail;
        po.setState("process");
        HQLTools.add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(SalePO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(SalePO po) {
        if(po == null)
            return ResultMessage.Fail;
        HQLTools.update(po);
        return ResultMessage.Success;
    }

    @Override
    public ArrayList<SalePO> getProcessList() {
        String operation = "from Sale where state = process";
        ArrayList<SalePO> list = (ArrayList<SalePO>)HQLTools.find(operation);
        return list;
    }

    @Override
    public void passCheck(SalePO po) {
        ArrayList<MemberPO> list = dataFactory.getMemberDataService().find
                ("", po.getRetailer(), "销售商");
        MemberPO memberPO = list.get(0);
        HQLTools.update(memberPO);

        memberPO.setPayment(po.getTotalPrice());
        Set<GoodsSalePO> set = po.getSaleSet();
        for(GoodsSalePO goodsSalePO : set){
            GoodsPO goodsPO = goodsSalePO.getPo();
            goodsPO.setCommodityNum(goodsPO.getCommodityNum() - goodsSalePO.getSaleNumber());
            HQLTools.update(goodsPO);
        }

    }

    @Override
    public void failCheck(SalePO po) {
        po.setState("fail");
        HQLTools.update(po);
    }

    @Override
    public SalePO addRed(SalePO po) {
        SalePO po1 = po;
        Set<GoodsSalePO> poSet = po.getSaleSet();
        Set<GoodsSalePO> poSet1 = new HashSet<>();
        for(GoodsSalePO goodsSalePO : poSet){
            GoodsSalePO po2 = goodsSalePO;
            po2.setSaleNumber( -1 * goodsSalePO.getSaleNumber());
            poSet1.add(po2);
        }
        po1.setSaleSet(poSet1);
        return po1;
    }

    @Override
    public ArrayList<SalePO> getSale(String startTime, String endTime, String userName, String memberName) {
        ArrayList<SalePO> list = (ArrayList<SalePO>)HQLTools.find("from Sale");
        int size = list.size();
        if(size == 0)
            return null;
        ArrayList<SalePO> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(dateHelper.isInRange(startTime, endTime, list.get(i).getDate())){
                if(list.get(i).getSalesman().equals(userName) && list.get(i).getRetailer().equals(memberName))
                    resultList.add(list.get(i));
            }
        }
        return list;
    }

    @Override
    public ArrayList<SalePO> getFail() {
        String operation = "from Sale where state = fail";
        ArrayList<SalePO> list = (ArrayList<SalePO>)HQLTools.find(operation);
        return list;
    }
}
