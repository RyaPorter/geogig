// automatically generated by the FlatBuffers compiler, do not modify

package org.locationtech.geogig.flatbuffers.generated.v1;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Commit extends Table {
  public static Commit getRootAsCommit(ByteBuffer _bb) { return getRootAsCommit(_bb, new Commit()); }
  public static Commit getRootAsCommit(ByteBuffer _bb, Commit obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public Commit __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public SHA parentIds(int j) { return parentIds(new SHA(), j); }
  public SHA parentIds(SHA obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__vector(o) + j * 24, bb) : null; }
  public int parentIdsLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public SHA treeId() { return treeId(new SHA()); }
  public SHA treeId(SHA obj) { int o = __offset(6); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  public String message() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer messageAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public ByteBuffer messageInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 8, 1); }
  public Person author() { return author(new Person()); }
  public Person author(Person obj) { int o = __offset(10); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public Person committer() { return committer(new Person()); }
  public Person committer(Person obj) { int o = __offset(12); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static void startCommit(FlatBufferBuilder builder) { builder.startObject(5); }
  public static void addParentIds(FlatBufferBuilder builder, int parentIdsOffset) { builder.addOffset(0, parentIdsOffset, 0); }
  public static void startParentIdsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(24, numElems, 8); }
  public static void addTreeId(FlatBufferBuilder builder, int treeIdOffset) { builder.addStruct(1, treeIdOffset, 0); }
  public static void addMessage(FlatBufferBuilder builder, int messageOffset) { builder.addOffset(2, messageOffset, 0); }
  public static void addAuthor(FlatBufferBuilder builder, int authorOffset) { builder.addOffset(3, authorOffset, 0); }
  public static void addCommitter(FlatBufferBuilder builder, int committerOffset) { builder.addOffset(4, committerOffset, 0); }
  public static int endCommit(FlatBufferBuilder builder) {
    int o = builder.endObject();
    builder.required(o, 6);  // tree_id
    builder.required(o, 8);  // message
    builder.required(o, 10);  // author
    builder.required(o, 12);  // committer
    return o;
  }
}

