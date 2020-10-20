package server.api.voxeldbs;

import util.Range3d;
import voxeldb.CellFactory;
import voxeldb.CellFactory.VoxelMapperInt32;
import voxeldb.VoxelCell;
import voxeldb.VoxelGeoRef;

public class AggregatedProcessingInt32Int32MappedAggregator extends AggregatedProcessingInt32 {

	private VoxelMapperInt32 mapper;
	private AggregatorInt32Int32 aggregator;

	public AggregatedProcessingInt32Int32MappedAggregator(CellFactory cellFactory, Range3d range, int aggregation_factor, VoxelGeoRef aggRef, VoxelMapperInt32 mapper, AggregatorInt32Int32 aggregator) {
		super(cellFactory, range, aggregation_factor, aggRef);
		this.mapper = mapper;
		this.aggregator = aggregator;
	}
	
	public void process(VoxelCell voxelCell, int xSrcStart, int ySrcStart, int zSrcStart, int xSrcEnd, int ySrcEnd, int zSrcEnd, int xSrcDstOffeset, int ySrcDstOffeset, int zSrcDstOffeset) {
		int[][][] src = mapper.map(voxelCell);
		aggregator.process(src, xSrcStart, ySrcStart, zSrcStart, xSrcEnd, ySrcEnd, zSrcEnd, dst, xSrcDstOffeset, ySrcDstOffeset, zSrcDstOffeset, aggregation_factor);		
	}
}
