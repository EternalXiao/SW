import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Polygon;

public class StarTrees extends DisplayTrees{
	public static final int DEFAULT_RADIUS=10;
	public static final int DEFAULT_VERTICES=11;
	public static void makeStars(Group root,double[] x,double[] y,double[] scale) {
		for(int i=0;i<x.length;i++) {
			Polygon p = makeStar(x[i],y[i],scale[i],DEFAULT_VERTICES,DEFAULT_RADIUS);
			root.getChildren().add(p);
		}
	}
	public static Polygon makeStar(double x,double y,double scale,int vertices,int radius) {
		double[] co = new double[2*vertices];
		for(int i=0;i<vertices;i++) {
			co[2*i]=x+scale*radius*Math.cos(2*4*i*Math.PI/vertices);
			co[2*i+1]=y+scale*radius*Math.sin(2*4*i*Math.PI/vertices);
		}
		Polygon p = new Polygon(co);
		p.setFill(Color.YELLOW);
		p.setStroke(Color.BLACK);
		return p;
	}
	@Override
	public void start(Stage stage) throws Exception{
		Group root = new Group();
		double[] x = {100,200,300,150,200};
		double[] y = {20,100,100,30,50};
		double[] scale = {1,0.5,0.8,0.2,0.15};
		DisplayTwoTrees.makeTwoTrees(root,x,y,scale);
		makeStars(root,x,y,scale);
		Scene scene = new Scene(root,600,300);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
