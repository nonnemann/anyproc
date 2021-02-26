import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EdgeDrawListener implements MouseListener
{
	private Point startPoint;
	private Point endPoint;
	
	@Override
	public void mouseClicked(MouseEvent event)
	{
	
	}
	
	@Override
	public void mousePressed(MouseEvent event)
	{
		startPoint = event.getLocationOnScreen();
	}
	
	@Override
	public void mouseReleased(MouseEvent event)
	{
		endPoint = event.getLocationOnScreen();
		
		if(App.edgeDrawMode && findComponentAt(startPoint) != findComponentAt(endPoint))
		{
			Edge edge = new Edge(startPoint, endPoint);
			
			edge.addToEdgeList();
			
			App.globalGraph.createConnectionSlot(edge);
			
			if(App.debugPrintout)
			{
				App.globalLogger.info("Edge between " + edge.getStartComponent().getName() + " and " + edge.getEndComponent().getName() + " created.");
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent event)
	{
	
	}
	
	@Override
	public void mouseExited(MouseEvent event)
	{
	
	}
	
	public Component findComponentAt(Point location) {
		Window window = findWindow();
		SwingUtilities.convertPointFromScreen(location, window);
		return SwingUtilities.getDeepestComponentAt(window, location.x, location.y);
	}
	
	private Window findWindow() {
		for (Window window : Window.getWindows()) {
			if (window.getMousePosition(true) != null)
				return window;
		}
		return null;
	}
}
