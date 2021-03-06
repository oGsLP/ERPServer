package service.blservice.Impl;

import objects.POtoVO;
import objects.ResultMessage;
import po.MemberPO;
import service.VOChangeToPO;
import service.blservice.MemberBLService;
import service.datafactory.DataFactory;
import service.datafactory.DataFactoryImpl;
import vo.MemberVO;

import java.rmi.RemoteException;

public class MemberBLServiceImpl implements MemberBLService {
    VOChangeToPO voChangeToPO = new VOChangeToPO();
    DataFactory dataFactory = new DataFactoryImpl();
    POtoVO pOtoVO = new POtoVO();

    @Override
    public ResultMessage addMember(MemberVO vo) throws RemoteException{
        if(vo == null)
            return ResultMessage.Fail;
        MemberPO po = voChangeToPO.membervo_to_memberpo(vo);
        dataFactory.getMemberDataService().add(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage deleteMember(MemberVO vo) throws RemoteException{
        if(vo == null)
            return ResultMessage.Fail;
        MemberPO po = voChangeToPO.membervo_to_memberpo(vo);
        dataFactory.getMemberDataService().delete(po);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage updateMember(MemberVO vo) throws RemoteException{
        if(vo == null)
            return ResultMessage.Fail;
        MemberPO po = voChangeToPO.membervo_to_memberpo(vo);
        dataFactory.getMemberDataService().update(po);
        return ResultMessage.Success;
    }

    @Override
    public MemberVO findMember(int number) {
        MemberPO po = dataFactory.getMemberDataService().find(number);
        MemberVO vo  = pOtoVO.memberPO_to_memberVO(po);
        return vo;
    }
}
