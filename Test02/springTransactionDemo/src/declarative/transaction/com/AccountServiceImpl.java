package declarative.transaction.com;

/**
 * 转帐业务实现
 * Created by 黄桂道 on 2017-2-8.
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    /**
     * @param in    转入帐号
     * @param out   转出的帐号
     * @param money 转帐金额
     */
    @Override
    public void transfer(String in, String out, Double money) {

        accountDao.outMoney(out, money);
        accountDao.inMoney(in, money);

    }
}
