package declarative.transaction.com;

/**
 * 转帐业务接口
 * Created by 黄桂道 on 2017-2-8.
 */
public interface AccountService {

    /**
     *
     * @param in 转入帐号
     * @param out 转出的帐号
     * @param money 转帐金额
     */
    void transfer(String in, String out, Double money);
}
