package asia.lhweb.furn.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2023/9/24
 */
public class MBGUtil {
    public static void main(String[] args) throws Exception {
        // 创建一个存储警告信息的列表
        List<String> warnings = new ArrayList<String>();
// 是否覆盖已存在的文件（true 表示覆盖）
        boolean overwrite = true;
// 指定 MyBatis 逆向工程配置文件的位置，文件直接放在项目下
        File configFile = new File("mbg.xml");
// 创建配置文件解析器，用于解析 MyBatis 逆向工程的配置文件
        ConfigurationParser cp = new ConfigurationParser(warnings);
// 解析配置文件，得到 MyBatis Generator 的 Configuration 对象
        Configuration config = cp.parseConfiguration(configFile);
// 创建默认的回调对象，用于指定是否覆盖已存在的文件
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
// 创建 MyBatisGenerator 对象，用于执行逆向工程
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
// 执行逆向工程生成代码
        myBatisGenerator.generate(null);
// 输出逆向生成成功的提示信息
        System.out.println("逆向生成 OK");

    }
}
