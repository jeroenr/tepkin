package com.github.jeroenr.tepkin.protocol.command

import com.github.jeroenr.bson.BsonDocument
import com.github.jeroenr.bson.BsonDsl._

case class ListIndexes(databaseName: String,
                       collectionName: String) extends Command {
  override def command: BsonDocument = "listIndexes" := collectionName
}
