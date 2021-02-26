import java.util.ArrayList;
import java.util.List;

public class ConnectionSettings
{
	private final SourceInSlot _origin, _destination;
	private ConnectionSettingsView _connectionSettingsView;
	private List<Transformation> _forwardTransformations, _backwardTransformations;
	
	public ConnectionSettings(SourceInSlot startSource, SourceInSlot endSource)
	{
		_origin = startSource;
		_destination = endSource;
		_forwardTransformations = new ArrayList<>();
		_backwardTransformations = new ArrayList<>();
	}
	
	
	public SourceInSlot getOrigin()
	{
		return _origin;
	}
	public SourceInSlot getDestination()
	{
		return _destination;
	}
	public String getOriginToolName()
	{
		return _origin.getSourceName();
	}
	public String getDestinationToolName()
	{
		return _destination.getSourceName();
	}
	
	
	public void setConnectionNodeView(ConnectionSettingsView connectionSettingsView)
	{
		_connectionSettingsView = connectionSettingsView;
	}
	public ConnectionSettingsView getConnectionNodeView()
	{
		return _connectionSettingsView;
	}
	
	
	public void setTransformations(boolean forward, List<Transformation> transformations)
	{
		if(forward)
			_forwardTransformations = transformations;
		else
			_backwardTransformations = transformations;
	}
	public List<Transformation> getTransformations(boolean forward)
	{
		if(forward)
			return _forwardTransformations;
		else
			return _backwardTransformations;
	}
}
