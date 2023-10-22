# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: pingpong.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='pingpong.proto',
  package='pingpong',
  syntax='proto3',
  serialized_options=b'\n\036com.epam.RPCprotocols.pingpongB\rPingPongProtoP\001',
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n\x0epingpong.proto\x12\x08pingpong\"\"\n\x0fPingPongRequest\x12\x0f\n\x07message\x18\x01 \x01(\t\" \n\rPingPongReply\x12\x0f\n\x07message\x18\x01 \x01(\t2W\n\x0fPingPongService\x12\x44\n\x0cSendPingPong\x12\x19.pingpong.PingPongRequest\x1a\x17.pingpong.PingPongReply\"\x00\x42\x31\n\x1e\x63om.epam.RPCprotocols.pingpongB\rPingPongProtoP\x01\x62\x06proto3'
)




_PINGPONGREQUEST = _descriptor.Descriptor(
  name='PingPongRequest',
  full_name='pingpong.PingPongRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='message', full_name='pingpong.PingPongRequest.message', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=28,
  serialized_end=62,
)


_PINGPONGREPLY = _descriptor.Descriptor(
  name='PingPongReply',
  full_name='pingpong.PingPongReply',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='message', full_name='pingpong.PingPongReply.message', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=64,
  serialized_end=96,
)

DESCRIPTOR.message_types_by_name['PingPongRequest'] = _PINGPONGREQUEST
DESCRIPTOR.message_types_by_name['PingPongReply'] = _PINGPONGREPLY
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

PingPongRequest = _reflection.GeneratedProtocolMessageType('PingPongRequest', (_message.Message,), {
  'DESCRIPTOR' : _PINGPONGREQUEST,
  '__module__' : 'pingpong_pb2'
  # @@protoc_insertion_point(class_scope:pingpong.PingPongRequest)
  })
_sym_db.RegisterMessage(PingPongRequest)

PingPongReply = _reflection.GeneratedProtocolMessageType('PingPongReply', (_message.Message,), {
  'DESCRIPTOR' : _PINGPONGREPLY,
  '__module__' : 'pingpong_pb2'
  # @@protoc_insertion_point(class_scope:pingpong.PingPongReply)
  })
_sym_db.RegisterMessage(PingPongReply)


DESCRIPTOR._options = None

_PINGPONGSERVICE = _descriptor.ServiceDescriptor(
  name='PingPongService',
  full_name='pingpong.PingPongService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  create_key=_descriptor._internal_create_key,
  serialized_start=98,
  serialized_end=185,
  methods=[
  _descriptor.MethodDescriptor(
    name='SendPingPong',
    full_name='pingpong.PingPongService.SendPingPong',
    index=0,
    containing_service=None,
    input_type=_PINGPONGREQUEST,
    output_type=_PINGPONGREPLY,
    serialized_options=None,
    create_key=_descriptor._internal_create_key,
  ),
])
_sym_db.RegisterServiceDescriptor(_PINGPONGSERVICE)

DESCRIPTOR.services_by_name['PingPongService'] = _PINGPONGSERVICE

# @@protoc_insertion_point(module_scope)