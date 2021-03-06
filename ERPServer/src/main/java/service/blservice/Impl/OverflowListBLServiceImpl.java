package service.blservice.Impl;

import objects.DateHelper;
import objects.POtoVO;
import objects.ResultMessage;
import po.OverflowListPO;
import service.VOChangeToPO;
import service.blservice.OverflowListBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.OverflowListVO;
import vo.UserVO;

import java.util.ArrayList;

public class OverflowListBLServiceImpl implements OverflowListBLService{
    DataFactory dataFactory = new DataFactoryImpl();
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    POtoVO pOtoVO = new POtoVO();

    @Override
    public ResultMessage addOverflowList(OverflowListVO vo) {
        OverflowListPO po = voChangeToPO.overflowListvo_to_overflowListpo(vo);
        ResultMessage msg = dataFactory.getOverflowListDataService().add(po);
        return msg;
    }

    @Override
    public ResultMessage deleteOverlowList(OverflowListVO vo) {
        OverflowListPO po = voChangeToPO.overflowListvo_to_overflowListpo(vo);
        ResultMessage msg = dataFactory.getOverflowListDataService().delete(po);
        return msg;
    }

    @Override
    public ResultMessage updateOverflowList(OverflowListVO vo) {
        OverflowListPO po = voChangeToPO.overflowListvo_to_overflowListpo(vo);
        ResultMessage msg = dataFactory.getOverflowListDataService().update(po);
        return msg;
    }

    @Override
    public ArrayList<OverflowListVO> getOverflowList(String startTime, String endTime, String userName) {
        ArrayList<OverflowListPO> poList = dataFactory.getOverflowListDataService().getOverflowList(startTime,
                endTime, userName);
        ArrayList<OverflowListVO> voList = new ArrayList<>();
        for(int i = 0; i < poList.size(); i++){
            voList.add(pOtoVO.overflowListVO_to_overflowListPO(poList.get(i)));
        }
        return voList;
    }

    @Override
    public OverflowListVO addOverflowListRed(OverflowListVO vo) {
        OverflowListPO po = voChangeToPO.overflowListvo_to_overflowListpo(vo);
        OverflowListPO redPo = dataFactory.getOverflowListDataService().addRed(po);
        OverflowListVO vo1 = pOtoVO.overflowListVO_to_overflowListPO(redPo);
        return vo1;
    }
}
