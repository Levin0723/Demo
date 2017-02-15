/**
 * 转帐DAO
 * Created by 黄桂道 on 2017-2-8.
 */
public interface AccountDao {

    public void outMoney(String out, Double money);

    public void inMoney(String in, Double money);
}
