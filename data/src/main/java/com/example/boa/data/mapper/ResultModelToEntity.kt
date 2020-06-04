package com.example.boa.data.mapper

import com.example.boa.data.entity.ResultEntity
import com.example.boa.domain.core.BaseMapper
import com.example.boa.domain.model.Result

class ResultModelToEntity : BaseMapper<Result, ResultEntity>() {
    override fun map(input: Result): ResultEntity = ResultEntity(
        input.id,
        input.term,
        input.wrapperType,
        input.kind,
        input.artistId,
        input.collectionId,
        input.trackId,
        input.artistName,
        input.collectionName,
        input.trackName,
        input.collectionCensoredName,
        input.trackCensoredName,
        input.artistViewUrl,
        input.collectionViewUrl,
        input.trackViewUrl,
        input.previewUrl,
        input.artworkUrl30,
        input.artworkUrl60,
        input.artworkUrl100,
        input.collectionPrice,
        input.trackPrice,
        input.collectionHdPrice,
        input.trackHdPrice,
        input.releaseDate,
        input.collectionExplicitness,
        input.trackExplicitness,
        input.discCount,
        input.discNumber,
        input.trackCount,
        input.trackNumber,
        input.trackTimeMillis,
        input.country,
        input.currency,
        input.primaryGenreName,
        input.isStreamable,
        input.contentAdvisoryRating,
        input.shortDescription,
        input.longDescription
    )
}