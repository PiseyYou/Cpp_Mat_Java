package server;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;

public class readpic {
    public static void main(String[] args) {
        //加载so文件
        System.load("/usr/bin/libopencv_java346.so");
//        1.读取原始图片
        Mat image = imread("/home/pisey/Pictures/Gstream/iframe.png");
        if (image.empty()) {
            System.err.println("加载图片出错，请检查图片路径！");
            return;
        }

        Mat mat = Imgcodecs.imread("D:/Users/xinjian09/Desktop/原图.jpg");
        System.out.println(mat);
        //2.显示图片
//        imshow("显示原始图像", image);
//        waitKey(0);

        //3.HighGui
//      HighGui.imshow("展示图片", image);
//		HighGui.waitKey();


//		Imgcodecs.imwrite("/home/pisey/Pictures/Gstream/1-copy.jpg", image);
		imwrite("/home/pisey/Pictures/Gstream/2-copy.jpg", image);

        //4.图片长宽
//    Mat image = imread("/home/pisey/Pictures/Gstream/iframe.png", IMREAD_COLOR);
//    System.out.println("图像宽x高：" + image.cols() + " x " + image.rows());
//    System.out.println("welcome to opencv");
    }
}
