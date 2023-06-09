/**
 *  Title      : LineFrame.java
 *  Description: This program is used to generate GPA line plots.
 *
 *  In this version, I implemented all of the above functions.
 *  @author  Yilun Deng
 *  @author  Yuanchi Zhou
 *  @version 1.0
 */
package boundary;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;


public class LineFrame extends JFrame {


    private static final long serialVersionUID = 1L;

    public LineFrame(String s,double score[]) {

        super(s);
        setContentPane(createDemoLine(score));

    }

    public void chart() {
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);

        this.setVisible(true);

    }

    /**
      * This method is used to generate the panel that displays the chart.
      */
    public JPanel createDemoLine(double score[]) {

        JFreeChart jfreechart = createChart(createDataset(score));

        return new ChartPanel(jfreechart);

    }

    /**
      * This method is used to generate the chart master object JFreeChart.
      */
    public JFreeChart createChart(DefaultCategoryDataset linedataset) {



        JFreeChart chart = ChartFactory.createLineChart("GPA", 

                "grade", 

                "score", 

                linedataset, 

                PlotOrientation.VERTICAL, 

                true, // include legend

                true, // tooltips

                false // urls

        );

        CategoryPlot plot = chart.getCategoryPlot();

        plot.setRangeGridlinesVisible(true); 

        plot.setBackgroundAlpha(0.3f); 

        NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();

        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        rangeAxis.setAutoRangeIncludesZero(true);

        rangeAxis.setUpperMargin(0.20);

        rangeAxis.setLabelAngle(Math.PI / 2.0);

        return chart;

    }



    public DefaultCategoryDataset createDataset(double score[]) {

        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();



        String series1 = "";




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
