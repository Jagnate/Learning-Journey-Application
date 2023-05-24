package boundary;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;


public class LineFrame extends ApplicationFrame {

    /**

     *

     */

    private static final long serialVersionUID = 1L;

    public LineFrame(String s,double score[]) {

        super(s);

        setContentPane(createDemoLine(score));

    }

    public void chart() {

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.pack();

        RefineryUtilities.centerFrameOnScreen(this);

        this.setVisible(true);

    }

// 生成显示图表的面板

    public JPanel createDemoLine(double score[]) {

        JFreeChart jfreechart = createChart(createDataset(score));

        return new ChartPanel(jfreechart);

    }

// 生成图表主对象JFreeChart

    public JFreeChart createChart(DefaultCategoryDataset linedataset) {

// 定义图表对象

        JFreeChart chart = ChartFactory.createLineChart("GPA", //折线图名称

                "grade", // 横坐标e68a843231313335323631343130323136353331333361323632名称

                "score", // 纵坐标名称

                linedataset, // 数据

                PlotOrientation.VERTICAL, // 水平显示图像

                true, // include legend

                true, // tooltips

                false // urls

        );

        CategoryPlot plot = chart.getCategoryPlot();

        plot.setRangeGridlinesVisible(true); //是否显示格子线

        plot.setBackgroundAlpha(0.3f); //设置背景透明度

        NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();

        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        rangeAxis.setAutoRangeIncludesZero(true);

        rangeAxis.setUpperMargin(0.20);

        rangeAxis.setLabelAngle(Math.PI / 2.0);

        return chart;

    }

// 生成数据

    public DefaultCategoryDataset createDataset(double score[]) {

        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();

// 各曲线名称

        String series1 = "";


// 横轴名称(列名称)

        String type1 = "first year";

        String type2 = "second year";

        String type3 = "third year";

        String type4 = "forth year";

        linedataset.addValue(score[0], series1, type1);

        linedataset.addValue(score[1], series1, type2);

        linedataset.addValue(score[2], series1, type3);

        linedataset.addValue(score[3], series1, type4);



        return linedataset;

    }

}