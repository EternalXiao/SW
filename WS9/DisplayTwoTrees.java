import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Polygon;

public class DisplayTwoTrees extends DisplayTrees{
	
	public static void makeTwoTrees(Group root,double[] x,double[] y,double[] scale) {
		for(int i=0;i<x.length;i++) {
			Rectangle r = new Rectangle(x[i]-scale[i]*DEFAULT_WIDTH/2,y[i]+scale[i]*DEFAULT_BASE,DEFAULT_WIDTH*scale[i],scale[i]*2*DEFAULT_WIDTH);
			Polygon p = new Polygon(x[i],y[i],x[i]-scale[i]*(DEFAULT_BASE/2-DEFAULT_WIDTH/2),y[i]+scale[i]*DEFAULT_BASE/2,x[i]-scale[i]*(DEFAULT_BASE/2-2*DEFAULT_WIDTH),y[i]+scale[i]*DEFAULT_BASE/2,x[i]-scale[i]*DEFAULT_BASE/2,y[i]+scale[i]*DEFAULT_BASE,x[i]+scale[i]*DEFAULT_BASE/2,y[i]+scale[i]*DEFAULT_BASE,x[i]+scale[i]*(DEFAULT_BASE/2-2*DEFAULT_WIDTH),y[i]+scale[i]*DEFAULT_BASE/2,x[i]+scale[i]*(DEFAULT_BASE/2-DEFAULT_WIDTH/2),y[i]+scale[i]*DEFAULT_BASE/2);
			r.setFill(Color.rgb(102, 51, 0));
			p.setFill(Color.rgb(0, 255, 51));
			p.setStroke(Color.BLACK);
			root.getChildren().add(r);
			root.getChildren().add(p);
		}
	}
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		double[] x = {100,200,300,150,200};
		double[] y = {20,100,100,30,50};
		double[] scale = {1,0.5,0.8,0.2,0.15};
		makeTwoTrees(root,x,y,scale);
		Scene scene = new Scene(root,600,300);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
