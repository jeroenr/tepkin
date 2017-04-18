package com.github.jeroenr.tepkin.protocol.command

import com.github.jeroenr.bson.BsonDocument
import com.github.jeroenr.bson.BsonDsl._

case object IsMaster extends AdminCommand {
  override val command: BsonDocument = "isMaster" := 1
}
